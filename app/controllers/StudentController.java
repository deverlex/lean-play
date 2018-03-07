package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Student;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.StudentStore;
import utils.Util;

import javax.inject.Inject;
import java.util.List;

public class StudentController extends Controller {

    @Inject
    private StudentStore studentStore;

    public Result create() {
        JsonNode json = request().body().asJson();

        if (json == null) {
            return badRequest(Util.createResponse("Expecting Json data", false));
        }
        Student student = Json.fromJson(json, Student.class);
        if (student == null) {
            return notFound(Util.createResponse("Student not found", false));
        }

        Student.db().save(student);
        JsonNode jsonObject = Json.toJson(student);
        return ok(Util.createResponse(jsonObject, true));
    }

    public Result fetchAll() {
        List<Student> students = Student.find.all();
        JsonNode jsonObject = Json.toJson(students);
        return ok(Util.createResponse(jsonObject, true));
    }

}

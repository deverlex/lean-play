package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Student;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.StudentStore;
import utils.Util;

public class StudentController extends Controller {

    public Result create() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            return badRequest(Util.createResponse("Expecting Json data", false));
        }
        Student student = StudentStore.getInstance().addStudent(Json.fromJson(json, Student.class));
        if (student == null) {
            return notFound(Util.createResponse("Student not found", false));
        }
        JsonNode jsonObject = Json.toJson(student);
        return ok(Util.createResponse(jsonObject, true));
    }

}

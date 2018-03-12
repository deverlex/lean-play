package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import services.TripiUser;
import utils.ResultFactory;
import utils.Util;

public class TripiUserController extends Controller {

    @Inject TripiUser tripiUser;

    public Result createUser() {
        JsonNode jsonNode = request().body().asJson();

        User user = new User();
        user.setFirstName(jsonNode.get("firstName").asText());
        user.setLastName(jsonNode.get("lastName").asText());
        user.setAge(Util.parseBirthdayFromString(jsonNode.get("birthday").asText()));

        if (tripiUser.createUser(user)) {
            return ok(ResultFactory.createResponse(true));
        }
        return ok(ResultFactory.createResponse(false));
    }

    public Result deleteUser(int userId) {
        if (tripiUser.deleteUser(userId)) {
            return ok(ResultFactory.createResponse(true));
        }
        return ok(ResultFactory.createResponse(false));
    }
}

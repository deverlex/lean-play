package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import services.TripiPortal;
import services.TripiUser;
import utils.ResultFactory;
import utils.Util;

public class TripiPortalController extends Controller {

    @Inject TripiUser tripiUser;

    @Inject TripiPortal tripiPortal;

    public Result getListBooker() {
        return ok(ResultFactory.createResponse(tripiPortal.getListBooker(), true));
    }

    public Result createBooker() {
        JsonNode requestBody = request().body().asJson();
        User user = new User();

        user.setFirstName(requestBody.get("firstName").asText());
        user.setLastName(requestBody.get("lastName").asText());
        user.setAge(Util.parseBirthdayFromString(requestBody.get("birthday").asText()));

        if (tripiUser.createUser(user)) {
            tripiPortal.createBooker(user);
            return ok(ResultFactory.createResponse(true));
        } else {
            return ok(ResultFactory.createResponse(false));
        }
    }

    public Result deleteBooker(int userId) {
        if (tripiPortal.deleteBooker(userId)) {
            return ok(ResultFactory.createResponse(true));
        } else {
            return ok(ResultFactory.createResponse(false));
        }
    }
}

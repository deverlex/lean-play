package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.Controller;
import play.mvc.Result;
import services.BookerAdmin;
import utils.Util;

import javax.inject.Inject;

public class BookerController extends Controller {

    @Inject
    BookerAdmin bookerAdmin;

    public Result registerBooker() {
        JsonNode jsonNode = request().body().asJson();

        try {
            return ok(Util.createResponse(bookerAdmin.registerBooker(jsonNode), true));
        } catch (Exception e) {
            return ok(Util.createResponse(e.getMessage(),false));
        }
    }
}

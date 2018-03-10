package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import component.BookerComponent;
import play.mvc.Controller;
import play.mvc.Result;
import services.BookerAdmin;
import services.Hello;
import utils.Util;

import javax.inject.Inject;

public class BookerController extends Controller {

    @Inject
    BookerAdmin bookerAdmin;

    // demo inject constructor
    @Inject
    BookerComponent bookerComponent;

    @Inject
    Hello hello;

    // demo inject method
    public Result helloBooker() {
        return ok(bookerAdmin.getHello());
    }

    public Result helloMulti(String lang, String name) {
        if (lang.equals("en")) {
           return ok(hello.sayHello(name));
        } else {
            return ok(hello.sayHello(name));
        }
    }

    // demo inject
    public Result registerBooker() {
        JsonNode jsonNode = request().body().asJson();

        try {
            return ok(Util.createResponse(bookerAdmin.registerBooker(jsonNode), true));
        } catch (Exception e) {
            return ok(Util.createResponse(e.getMessage(),false));
        }
    }

}

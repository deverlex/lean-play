package services;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Booker;
import models.User;
import utils.Util;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Date;

@Singleton
public class BookerAdmin {

    private HelloService helloService;

    public JsonNode registerBooker(JsonNode json) {
        String firstName = json.get("firstName").asText();
        String lastName = json.get("lastName").asText();
        Date age = Util.parseBirthdayFromString(json.get("age").asText());
        User user = new User();
        user.setAge(age);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        User.db().save(user);

        JsonNode bookerNode = json.get("booker");
        float topup = bookerNode.get("topup").floatValue();
        Booker booker = new Booker();
        booker.setUserId(user.getId());
        booker.setTopup(topup);

        Booker.db().save(booker);

        ObjectNode jsonNodes = JsonNodeFactory.instance.objectNode();
        jsonNodes.putPOJO("user", user);
        jsonNodes.putPOJO("booker", booker);

        return jsonNodes;
    }

    @Inject
    public void setHelloAdmin(HelloService helloService) {
        this.helloService = helloService;
    }

    public String getHello() {
        return helloService.getHello();
    }
}

package services.impl;

import com.avaje.ebean.Transaction;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Booker;
import models.User;
import play.libs.Json;
import services.TripiPortal;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class TripiPortalImpl implements TripiPortal {

    @Override
    public boolean createBooker(User user) {
        Booker booker = new Booker();
        booker.setActive(true);
        booker.setUserId(user.getId());
        booker.setTopup(500.000f);

        Booker.db().save(booker);

        return booker.getId() >= 0;
    }

    @Override
    public boolean deleteBooker(int userId) {
        try {
            Transaction transaction = Booker.db().beginTransaction();
            Booker booker = Booker.db().find(Booker.class).where().eq("user_id", userId).findUnique();
            Booker.db().delete(booker, transaction);
            transaction.commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<JsonNode> getListBooker() {
        List<JsonNode> result = new ArrayList<>();
        List<Booker> bookers = Booker.db().find(Booker.class).findList();

        for (Booker booker : bookers) {
            User user = User.db().find(User.class).where().eq("id", booker.getUserId()).findUnique();
            ObjectNode node = (ObjectNode) Json.toJson(booker);
            node.putPOJO("userDetails", user);

            result.add(node);
        }
        return result;
    }

}

package services.impl;

import com.fasterxml.jackson.databind.node.ObjectNode;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import models.Ticket;
import models.TicketFlight;
import models.TicketHotel;
import play.libs.Json;
import services.TripiTicketService;

import java.util.LinkedList;
import java.util.List;

public class TripiTicketServiceImpl implements TripiTicketService {

    @Override
    public Single<ObjectNode> findCheapTicket() {
        return Single.create((SingleEmitter<ObjectNode> emitter) -> {
            List<Ticket> tickets = new LinkedList<>();
            ObjectNode objectNode = Json.newObject();

            // example - find cheap must be diff sql query
            TicketHotel ticketHotel = TicketHotel.db().find(TicketHotel.class)
                    .where().orderBy("price").findList().get(0);

            TicketFlight ticketFlight = TicketFlight.db().find(TicketFlight.class)
                    .where().orderBy("price").findList().get(0);

            if (ticketFlight != null) {
                tickets.add(ticketFlight);
            }

            if (ticketHotel != null) {
                tickets.add(ticketHotel);
            }

            objectNode.putPOJO("tickets", tickets);
            objectNode.putPOJO("polling", true);
            objectNode.putPOJO("page", 1);

            emitter.onSuccess(objectNode);
        });
    }

    @Override
    public Single<ObjectNode> findTicketHotel() {
        return Single.create((SingleEmitter<ObjectNode> emitter) -> {
            ObjectNode objectNode = Json.newObject();

            TicketHotel ticketHotel = TicketHotel.db().find(TicketHotel.class)
                    .where().orderBy("price").findList().get(0);
            objectNode.putPOJO("hotel", ticketHotel);
            emitter.onSuccess(objectNode);
        });
    }

    @Override
    public Single<ObjectNode> findTicketFlight() {
        return Single.create((SingleEmitter<ObjectNode> emitter) -> {
            ObjectNode objectNode = Json.newObject();

            TicketFlight ticketFlight = TicketFlight.db().find(TicketFlight.class)
                    .where().orderBy("price").findList().get(0);
            objectNode.putPOJO("flight", ticketFlight);
            emitter.onSuccess(objectNode);
        });
    }

}

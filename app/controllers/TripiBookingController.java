package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import models.Ticket;
import models.TicketFlight;
import models.TicketHotel;
import play.mvc.Controller;
import play.mvc.Result;
import services.TripiBooking;
import utils.ResultFactory;
import utils.Util;

import javax.inject.Named;

public class TripiBookingController extends Controller {

    @Inject @Named("tripiBookingFlight") TripiBooking tripiBookingFlight;

    @Inject @Named("tripiBookingHotel") TripiBooking tripiBookingHotel;

    public Result bookingTicket() {
        JsonNode jsonNode = request().body().asJson();

        if (jsonNode.get("module").asText().equals("flight")) {
            TicketFlight ticket = new TicketFlight();
            ticket.setPrice(jsonNode.get("price").asDouble());
            ticket.setDepartDate(Util.parseTimeBookingFromString(jsonNode.get("departTime").asText()));

            if (tripiBookingFlight.booking(ticket)) {
                return ok(ResultFactory.createResponse(true));
            }
        } else if (jsonNode.get("module").asText().equals("hotel")) {
            TicketHotel ticket = new TicketHotel();
            ticket.setNumRoom(jsonNode.get("numRoom").asInt());
            ticket.setPrice(jsonNode.get("price").asDouble());
            tripiBookingHotel.booking(ticket);

            if (tripiBookingHotel.booking(ticket)) {
                return ok(ResultFactory.createResponse(true));
            }
        }

        return ok(ResultFactory.createResponse(false));
    }
}

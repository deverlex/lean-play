package services.impl;

import models.Ticket;
import models.TicketFlight;
import services.TripiBooking;

public class TripiBookingFlightImpl implements TripiBooking {


    @Override
    public boolean booking(Ticket ticket) {
        TicketFlight.db().save(ticket);
        return ((TicketFlight) ticket).getId() >= 0;
    }
}

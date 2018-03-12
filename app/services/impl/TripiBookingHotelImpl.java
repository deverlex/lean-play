package services.impl;

import models.Ticket;
import models.TicketHotel;
import services.TripiBooking;

public class TripiBookingHotelImpl implements TripiBooking {

    @Override
    public boolean booking(Ticket ticket) {
        TicketHotel.db().save(ticket);
        return ((TicketHotel) ticket).getId() >= 0;
    }
}

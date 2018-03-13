package services.impl;

import models.Ticket;
import models.TicketFlight;
import models.TicketHotel;
import services.Promotion;

public class PromotionImpl implements Promotion {

    @Override
    public double calculatePrice(float percent, Ticket ticket) {
        if (ticket instanceof TicketFlight) {
            double ticketPrice = ((TicketFlight) ticket).getPrice();
            return  ticketPrice - ticketPrice * percent - 1000;
        } else if (ticket instanceof TicketHotel) {
            double ticketPrice = ((TicketHotel) ticket).getPrice();
            return ticketPrice - ticketPrice * percent - 1200;
        }
        return -1;
    }
}

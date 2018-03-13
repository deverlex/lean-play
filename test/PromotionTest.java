import com.google.inject.Inject;
import models.TicketFlight;
import models.TicketHotel;
import org.junit.Test;
import services.Promotion;

import static org.junit.Assert.assertEquals;

/**
 * Copyright(c) Tripi 2018
 */

public class PromotionTest extends TestBase {

    @Inject
    Promotion promotion;

    @Test
    public void testCalculatePrice() {
        TicketHotel ticketHotel = new TicketHotel();
        ticketHotel.setPrice(1000000);
        double priceHotel = promotion.calculatePrice(0.01f, ticketHotel);

        TicketFlight ticketFlight = new TicketFlight();
        ticketFlight.setPrice(1000000);
        double priceFlight = promotion.calculatePrice(0.01f, ticketFlight);

        assertEquals(true, priceHotel < priceFlight);
    }
}

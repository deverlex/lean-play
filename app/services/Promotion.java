package services;

import com.google.inject.ImplementedBy;
import models.Ticket;
import services.impl.PromotionImpl;

@ImplementedBy(PromotionImpl.class)
public interface Promotion {

    double calculatePrice(float percent, Ticket ticket);
}

package services;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.ImplementedBy;
import io.reactivex.Single;
import services.impl.TripiTicketServiceImpl;

@ImplementedBy(TripiTicketServiceImpl.class)
public interface TripiTicketService {

    Single<ObjectNode> findCheapTicket();
}

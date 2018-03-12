package services;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.ImplementedBy;
import models.User;
import services.impl.TripiPortalImpl;

import java.util.List;

@ImplementedBy(TripiPortalImpl.class)
public interface TripiPortal {

    boolean createBooker(User user);

    boolean deleteBooker(int userId);

    List<JsonNode> getListBooker();

}


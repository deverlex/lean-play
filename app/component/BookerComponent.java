package component;

import services.BookerAdmin;

import javax.inject.Inject;

public class BookerComponent {

    @Inject
    public BookerComponent(BookerAdmin bookerAdmin) {

    }
}

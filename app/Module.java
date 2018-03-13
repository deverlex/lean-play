import com.google.inject.AbstractModule;
import java.time.Clock;

import com.google.inject.name.Names;
import services.*;
import services.impl.TripiBookingFlightImpl;
import services.impl.TripiBookingHotelImpl;
import services.impl.TripiTicketServiceImpl;

/**
 * This class is a Guice module that tells Guice how to bind several
 * different types. This Guice module is created when the Play
 * application starts.
 *
 * Play will automatically use any class called `Module` that is in
 * the root package. You can create modules in other locations by
 * adding `play.modules.enabled` settings to the `application.conf`
 * configuration file.
 */
public class Module extends AbstractModule {

    @Override
    public void configure() {
        // Use the system clock as the default implementation of Clock
        bind(Clock.class).toInstance(Clock.systemDefaultZone());
        // Ask Guice to create an instance of ApplicationTimer when the
        // application starts.
        bind(ApplicationTimer.class).asEagerSingleton();
        // Set AtomicCounter as the implementation for Counter.
        bind(Counter.class).to(AtomicCounter.class);

        bind(TripiBooking.class)
                .annotatedWith(Names.named("tripiBookingFlight"))
                .to(TripiBookingFlightImpl.class)
                .asEagerSingleton();

        bind(TripiBooking.class)
                .annotatedWith(Names.named("tripiBookingHotel"))
                .to(TripiBookingHotelImpl.class)
                .asEagerSingleton();
    }

}

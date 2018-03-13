import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Before;
import services.Promotion;

public class TestBase {

    protected Injector injector = Guice.createInjector(new AbstractModule() {
        @Override
        protected void configure() {
            bind(Promotion.class);
        }
    });

    @Before
    public void setup () {
        injector.injectMembers(this);
    }

}

package services;

import com.google.inject.ImplementedBy;

@ImplementedBy(value = HelloEnglish.class)
public interface Hello {

    String sayHello(String nameBooker);
}

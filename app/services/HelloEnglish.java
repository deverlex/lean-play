package services;

public class HelloEnglish implements Hello {

    @Override
    public String sayHello(String nameBooker) {
        return "Hello " + nameBooker;
    }
}

package services;

public class HelloVietnamese implements Hello {

    @Override
    public String sayHello(String nameBooker) {
        return "Xin chào " + nameBooker;
    }
}

import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

    public MessagePrinter() {
        super();
        System.out.println("MessagePrinter");
    }

    public MessageService getService() {
        return service;
    }

    public void setService(MessageService service) {
        this.service = service;
    }

    private MessageService service;
    public void printMessage(){
        System.out.println(this.service.getMessage());

    }


}

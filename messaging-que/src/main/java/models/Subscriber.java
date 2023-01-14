package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class Subscriber {

    private String id;

    private String name;

    public Subscriber(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }


    public void messagePublished(Message message){

        System.out.println("MessagedReceiver to  " + name + " -- "+message.getData());

    }
}

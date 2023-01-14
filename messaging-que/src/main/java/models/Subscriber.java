package models;

import lombok.Getter;

import java.util.List;

@Getter
public class Subscriber {

    private String id;

    private String name;


    public void messagePublished(Message message){

        System.out.println("MessagedReceiver to  " + id + " -- "+message.getData());

    }
}

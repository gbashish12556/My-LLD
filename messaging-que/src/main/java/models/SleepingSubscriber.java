package models;

import lombok.Getter;

import java.util.UUID;

@Getter
public class SleepingSubscriber implements Subscriber{

    private String id;

    private String name;

    public SleepingSubscriber(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }


    public void consume(Message message){

        try {
            Thread.sleep(1000);
            System.out.println("MessagedReceiver to  " + name + " -- "+message.getData());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

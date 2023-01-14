package models;

import lombok.Getter;
import service.SubscriberWorker;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
public class Topic {
    private String id;
    private String name;
    private ArrayList<Message> messages = new ArrayList<>();

    private HashMap<String, SubscriberWorker> subscribers= new HashMap<>();

    public Topic(String id, String name) {
        this.id = id;
        this.name = name;
    }


    public void subscribe(SubscriberWorker subscriberWorker){


        subscribers.put(subscriberWorker.getId(), subscriberWorker);

        (new Thread(subscriberWorker)).start();


    }

    public void unsubscribe(String subscriberId){

        subscribers.remove(subscriberId);

    }

    public void publishMessage(Message message){

        synchronized (this) {

            messages.add(message);
            this.notifyAll();

        }

    }

}

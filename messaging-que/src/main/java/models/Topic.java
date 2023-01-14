package models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
public class Topic {
    private String id;
    private String name;
    private ArrayList<Message> messages = new ArrayList<>();

    private HashMap<String, Subscriber> subscribers= new HashMap<>();

    public Topic(String id, String name) {
        this.id = id;
        this.name = name;
    }


    public void subscribe(Subscriber subscriber){

        subscribers.put(subscriber.getId(), subscriber);

    }

    public void unsubscribe(String subscriberId){

        subscribers.remove(subscriberId);

    }

    public void publishMessage(Message message){

        messages.add(message);

        ArrayList<Subscriber> subs = new ArrayList<>(subscribers.values());
        int size = subscribers.size();
        for(int i=0 ; i<size; i++){

            subs.get(i).messagePublished(message);

        }

    }

}

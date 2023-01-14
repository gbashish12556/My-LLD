package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@AllArgsConstructor
public class TopicSubscriber {

    private AtomicInteger offset;
    private Subscriber subscriber;

    public void consume(Message message){

        subscriber.consume(message);

    }




}

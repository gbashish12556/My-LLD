package service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import models.SleepingSubscriber;
import models.Topic;
import models.TopicSubscriber;

@Getter
@AllArgsConstructor
public class SubscriberWorker implements Runnable{

    private String id;

    private Topic topic;

    private TopicSubscriber topicSubscriber;

    @Override
    public void run() {

        synchronized (topic) {

            while(true) {

                if (topicSubscriber.getOffset().getOpaque() >= topic.getMessages().size()) {

                    try {

                        topic.wait();

                    } catch (InterruptedException e) {

                        throw new RuntimeException(e);

                    }

                } else {

                    int val = topicSubscriber.getOffset().get();
                    topicSubscriber.consume(topic.getMessages().get(val));
                    topicSubscriber.getOffset().set(val+1);

                }
            }
        }

    }

}

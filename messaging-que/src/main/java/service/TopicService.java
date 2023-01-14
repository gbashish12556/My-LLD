package service;

import models.Message;
import models.SleepingSubscriber;
import models.Subscriber;
import models.Topic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class TopicService {

    private HashMap<String, Topic> topicMapping = new HashMap<>();


    public void createTopic(String name){

        String id = UUID.randomUUID().toString();
        Topic topic = new Topic(id, name);
        topicMapping.put(id, topic);

    }

    public Topic getTopic(String id){

        return topicMapping.get(id);

    }

    public void subscribe(String topicId, SubscriberWorker subscriberWorker){

        topicMapping.get(topicId).subscribe(subscriberWorker);

    }


    public void unsubscribe(String topicId, String subscriberId){

        topicMapping.get(topicId).unsubscribe(subscriberId);

    }

    public void publishMessage(String id, Message message){

        (new Thread(new Runnable() {
            @Override
            public void run() {

                topicMapping.get(id).publishMessage(message);

            }
        })).start();

    }

    public List<Topic> getAllTopic(){

        return new ArrayList<>(topicMapping.values());

    }

}

package org.example;

import controlller.PublisherController;
import controlller.SubscriberController;
import enums.MessageType;
import models.Message;
import models.Subscriber;
import models.Topic;
import service.TopicService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        TopicService topicService  = new TopicService();

        PublisherController publisherController = new PublisherController(topicService);

        publisherController.createTopic("Sports");


        SubscriberController subscriberController = new SubscriberController(topicService);


        List<Topic> topics = subscriberController.getAllTopics();

        Subscriber subscriber1 = new Subscriber("Subs1");
        Subscriber subscriber2 = new Subscriber("Subs2");


        Topic topic = topics.get(0);
        topic.subscribe(subscriber1);
        topic.subscribe(subscriber2);

        publisherController.publishMessage(topic.getId(), new Message(MessageType.TEXT, "Sachin is Legend"));

//        subscriberController.subscribe();


    }
}
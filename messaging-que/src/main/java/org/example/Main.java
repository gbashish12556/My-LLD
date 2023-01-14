package org.example;

import controlller.PublisherController;
import controlller.SubscriberController;
import enums.MessageType;
import models.Message;
import models.SleepingSubscriber;
import models.Topic;
import models.TopicSubscriber;
import service.SubscriberWorker;
import service.TopicService;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {

        TopicService topicService  = new TopicService();

        PublisherController publisherController = new PublisherController(topicService);

        publisherController.createTopic("Sports");


        SubscriberController subscriberController = new SubscriberController(topicService);


        List<Topic> topics = subscriberController.getAllTopics();
        Topic topic = topics.get(0);

        TopicSubscriber topicSubscriber = new TopicSubscriber(new AtomicInteger(5), new SleepingSubscriber("name"));
        SubscriberWorker subscriberWorker1 = new SubscriberWorker(UUID.randomUUID().toString(), topic, topicSubscriber);

        topic.subscribe(subscriberWorker1);

        publisherController.publishMessage(topic.getId(), new Message(MessageType.TEXT, "Sachin is Legend"));
        publisherController.publishMessage(topic.getId(), new Message(MessageType.TEXT, "Sachin is Batsman"));
        publisherController.publishMessage(topic.getId(), new Message(MessageType.TEXT, "Sachin is Bowler"));
        publisherController.publishMessage(topic.getId(), new Message(MessageType.TEXT, "Sachin is Player"));
        publisherController.publishMessage(topic.getId(), new Message(MessageType.TEXT, "Sachin is Winner"));
        publisherController.publishMessage(topic.getId(), new Message(MessageType.TEXT, "Sachin is Nervous"));
        publisherController.publishMessage(topic.getId(), new Message(MessageType.TEXT, "Sachin is Husband"));



    }
}
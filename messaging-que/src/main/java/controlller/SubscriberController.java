package controlller;

import lombok.AllArgsConstructor;
import models.SleepingSubscriber;
import models.Topic;
import service.SubscriberWorker;
import service.TopicService;

import java.util.List;

@AllArgsConstructor
public class SubscriberController {

    private TopicService topicService;


    public void subscribe(String topicId, SubscriberWorker subscriberWorker){

        topicService.subscribe(topicId, subscriberWorker);

    }

    public void unsubscribe(String topicid, String subscriberId){

            topicService.unsubscribe(topicid, subscriberId);

    }

    public List<Topic> getAllTopics(){

        return topicService.getAllTopic();

    }


}

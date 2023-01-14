package controlller;

import lombok.AllArgsConstructor;
import models.Subscriber;
import models.Topic;
import service.TopicService;

import java.util.List;

@AllArgsConstructor
public class SubscriberController {

    private TopicService topicService;


    public void subscribe(String id, Subscriber subscriber){

        topicService.subscribe(id,subscriber);

    }

    public void unsubscribe(String id){

//        to

    }

    public List<Topic> getAllTopics(){

        return topicService.getAllTopic();

    }


}

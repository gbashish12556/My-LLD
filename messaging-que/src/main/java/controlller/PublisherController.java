package controlller;

import lombok.AllArgsConstructor;
import models.Message;
import service.TopicService;

@AllArgsConstructor
public class PublisherController {


    private TopicService topicService;


    public void createTopic(String name){

        topicService.createTopic(name);

    }

    public void publishMessage(String id, Message message){

        topicService.publishMessage(id, message);

    }



}

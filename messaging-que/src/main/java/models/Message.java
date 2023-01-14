package models;

import enums.MessageType;
import lombok.Getter;

@Getter
public class Message {


    private String id;

    private MessageType messageType;

    private String data;

    public Message(MessageType messageType, String data) {
        this.messageType = messageType;
        this.data = data;
    }
}

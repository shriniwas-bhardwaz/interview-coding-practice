package LowLevelDesign.ThreadDesign.MultiThreadedMessageQueues.model;


import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Topic {
    private final String topicName;
    private final String topicId;
    private final List<Message> messages; // TODO: Change getter this to send only immutable list outside.
    private final List<TopicSubscriber> subscribers; // TODO: Change getter this to send only immutable list outside.

    public Topic(@NonNull final String topicName, @NonNull final String topicId) {
        this.topicName = topicName;
        this.topicId = topicId;
        this.messages = new ArrayList<>();
        this.subscribers = new ArrayList<>();
    }

    public synchronized void addMessage(@NonNull final Message message) {
        messages.add(message);
    }

    public void addSubscriber(@NonNull final TopicSubscriber subscriber) {
        subscribers.add(subscriber);
    }
}

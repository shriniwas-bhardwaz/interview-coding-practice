package LowLevelDesign.ThreadDesign.MultiThreadedMessageQueues.public_interface;

import LowLevelDesign.ThreadDesign.MultiThreadedMessageQueues.model.Message;

public interface ISubscriber {

    String getId();
    void consume(Message message) throws InterruptedException;
}
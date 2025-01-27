package LowLevelDesign.DesignSnakeAndLadder;


/* Used to encapsulate a request as an object to parameterize
clients with queues,requests and operations.*/
public interface Command {

    void execute();
}

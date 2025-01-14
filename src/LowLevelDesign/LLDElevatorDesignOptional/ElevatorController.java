package LowLevelDesign.LLDElevatorDesignOptional;

import java.util.PriorityQueue;

public class ElevatorController {
    PriorityQueue<Integer> upMinPQ;
    PriorityQueue<Integer> downMaxPQ;
    ElevatorCar elevatorCar;

    ElevatorController(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
        upMinPQ = new PriorityQueue<>();
        downMaxPQ = new PriorityQueue<>((a, b) -> b - a);
    }

    public void submitExternalRequest(int floor, Direction direction) {
        if (direction == Direction.DOWN) {
            downMaxPQ.offer(floor);
        } else {
            upMinPQ.offer(floor);
        }
    }

    public void submitInternalRequest(int floor) {
        // Handle internal requests
        if (floor > elevatorCar.currentFloor) {
            elevatorCar.elevatorDirection = Direction.UP;
            elevatorCar.moveElevator(Direction.UP, floor);
        } else if (floor < elevatorCar.currentFloor) {
            elevatorCar.elevatorDirection = Direction.DOWN;
            elevatorCar.moveElevator(Direction.DOWN, floor);
        }
    }

    public void controlElevator() {
        while (true) {
            if (!upMinPQ.isEmpty()) {
                int nextFloor = upMinPQ.poll();
                elevatorCar.elevatorDirection = Direction.UP;
                elevatorCar.moveElevator(Direction.UP, nextFloor);
            } else if (!downMaxPQ.isEmpty()) {
                int nextFloor = downMaxPQ.poll();
                elevatorCar.elevatorDirection = Direction.DOWN;
                elevatorCar.moveElevator(Direction.DOWN, nextFloor);
            }
        }
    }
}
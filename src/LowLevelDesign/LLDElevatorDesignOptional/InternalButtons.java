package LowLevelDesign.LLDElevatorDesignOptional;

public class InternalButtons {
    InternalDispatcher dispatcher = new InternalDispatcher();
    int[] availableButtons = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    void pressButton(int destination, ElevatorCar elevatorCar) {
        if (destination >= 1 && destination <= availableButtons.length) {
            dispatcher.submitInternalRequest(destination, elevatorCar);
        } else {
            System.out.println("Invalid floor selected.");
        }
    }
}
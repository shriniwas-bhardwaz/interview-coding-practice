package LowLevelDesign.DesignVendingMachine;

import LowLevelDesign.DesignVendingMachine.VendingStates.State;
import LowLevelDesign.DesignVendingMachine.VendingStates.impl.IdleState;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private State vendingMachineState;

    private Inventory inventory;

    private List<Coin> coin;

    public VendingMachine() {
        vendingMachineState = new IdleState();
        coin = new ArrayList<>();
        inventory = new Inventory(10);
    }

    public State getVendingMachineState() {
        return vendingMachineState;
    }

    public void setVendingMachineState(State vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<Coin> getCoin() {
        return coin;
    }

    public void setCoin(List<Coin> coin) {
        this.coin = coin;
    }
}

package LowLevelDesign.DesignOrderManagementSystem;

import java.util.List;

//In a system there can be multiple warehouses so we will create a warehouse controller.
/* When a user comes all of its requirements are to be satisfied by one of the warehouses.
   Not multiple warehouses . In a city there can be multiple warehouses.
   So there should be a strategy to select warehouses.
   There could be different algorithms like
   - Nearest Warehouse Selection Strategy
   - Cheapest Warehouse Selection Strategy

*/
public class WarehouseController {

    List<Warehouse> warehouseList;
    WarehouseSelectionStrategy warehouseSelectionStrategy = null;

    WarehouseController(List<Warehouse> warehouseList, WarehouseSelectionStrategy warehouseSelectionStrategy){
        this.warehouseList = warehouseList;
        this.warehouseSelectionStrategy = warehouseSelectionStrategy;
    }

    //add new warehouse
    public void addNewWarehouse(Warehouse warehouse){
        warehouseList.add(warehouse);
    }

    //remove warehouse
    public void removeWarehouse(Warehouse warehouse){
        warehouseList.remove(warehouse);
    }

    public Warehouse selectWarehouse(WarehouseSelectionStrategy selectionStrategy){
        this.warehouseSelectionStrategy = selectionStrategy;
        return warehouseSelectionStrategy.selectWarehouse(warehouseList);
    }
}

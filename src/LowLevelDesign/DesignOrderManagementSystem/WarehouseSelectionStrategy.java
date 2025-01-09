package LowLevelDesign.DesignOrderManagementSystem;

import java.util.List;

/* When a user comes all of its requirements are to be satisfied by one of the warehouses.
   Not multiple warehouses . In a city there can be multiple warehouses.
   So there should be a strategy to select warehouses.
   There could be different algorithms like
   - Nearest Warehouse Selection Strategy
   - Cheapest Warehouse Selection Strategy

*/
public abstract class WarehouseSelectionStrategy {

    public abstract Warehouse selectWarehouse(List<Warehouse> warehouseList);
}

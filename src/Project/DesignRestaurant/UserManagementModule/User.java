package Project.DesignRestaurant.UserManagementModule;


import Project.DesignRestaurant.OrderManagementModule.Order;

import java.util.List;

public class User {

    private String name;
    private String userName;
    private String password;

    private Location location;

    private String email;

    private String mobileNumber;

    private int balance;
    private List<Order> orderList;


    private String getName() {
        return this.name;
    }
}

package LowLevelDesign.DesignOrderManagementSystem;

import java.util.ArrayList;
import java.util.List;

// Cart is very much related to an user. One user will have only one cart.
public class User {

    int userId;
    String userName;
    Address address;
    Cart userCartDetails;
    List<Integer> orderIds; // user will have all orderIds. From this info it can check
                            // what and all order it has created in the past.

    public User(){
        userCartDetails = new Cart();
        orderIds = new ArrayList<>();
    }

    //get UserCart
    public Cart getUserCart(){
        return userCartDetails;
    }
}

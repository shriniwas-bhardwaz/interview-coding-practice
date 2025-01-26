package LowLevelDesign.PaymentSystemLLD.User;

public class UserController {

    /* It is like front facing for this user service */

    UserService userService;

    public  UserController() {
        userService = new UserService();
    }


    public UserDAO addUser(UserDAO userObj) {
        return userService.addUser(userObj);
    }

    public UserDAO getUser(int userId) {
        return  userService.getUser(userId);
    }
}

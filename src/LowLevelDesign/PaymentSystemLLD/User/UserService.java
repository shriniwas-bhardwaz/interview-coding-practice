package LowLevelDesign.PaymentSystemLLD.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserService {

    /* There can be many users in the system. So it maintains a list of users as we
    dont have database. */

    static List<User> userList = new ArrayList<>();

    public UserDAO addUser(UserDAO userDAO) {
        User user  = new User();
        user.setUserName(userDAO.getName());
        user.setEmail(userDAO.getMail());
        user.setUserId((int) new Random().nextInt(100) +10);
        userList.add(user);
        return convertUserToUserDao(user);
    }

    public UserDAO getUser(int userId) {
        for(User user : userList) {
            if(user.getUserId() == userId) {
                return convertUserToUserDao(user);
            }
        }
        return  null;
    }


    private UserDAO convertUserToUserDao(User user) {
        UserDAO userDAO = new UserDAO();
        userDAO.setName(user.getUserName());
        userDAO.setMail(user.getEmail());
        userDAO.setUserId(user.getUserId());

        return userDAO;
    }
}

package org.example.datastore;

import org.example.exceptions.ExceptionType;
import org.example.exceptions.RestaurantException;
import org.example.model.User;

import java.util.HashMap;

public class UserData {

    private HashMap<Integer, User> userById = new HashMap<>();

    public User getUserFromId(Integer userId) throws RestaurantException {

        if(!userById.containsKey(userId)){
            throw new RestaurantException(ExceptionType.USER_NOT_FOUND, "Not Found");
        }

        return userById.get(userId);

    }

    public void addUser(User user) throws RestaurantException{

        if(userById.containsKey(user.getId())){

            throw new RestaurantException(ExceptionType.USER_EXIST, "User Exist");

        }

        userById.put(user.getId(), user);

    }

    public void deleteUserProfile(User user) throws RestaurantException{

        if(!userById.containsKey(user)){
            throw new RestaurantException(ExceptionType.USER_NOT_FOUND, "User Not Found");
        }

        userById.remove(user);

    }


}

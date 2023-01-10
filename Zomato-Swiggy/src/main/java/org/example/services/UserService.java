package org.example.services;

import org.example.datastore.UserData;
import org.example.exceptions.ExceptionType;
import org.example.exceptions.RestaurantException;
import org.example.model.User;

import java.util.HashMap;


public class UserService {


    private UserData userData;

    UserService(UserData userData){
        this.userData = userData;
    }

    void registerUser(User user) throws RestaurantException {

        userData.addUser(user);

    }

    void updateUserProfile(User user) throws RestaurantException{

       userData.addUser(user);

    }

    void deleteUserProfile(User user) throws RestaurantException{

            userData.deleteUserProfile(user);

    }

}

package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Getter
public class Theatre {
    private String id;
    private String name;
    private List<Screen> screens = new ArrayList<>();

    public Theatre(String id, String name) {
        this.id = id;
        this.name = name;

        intialiseScreens();

    }

    private void intialiseScreens(){

        for(int i=0;i<5;i++){

            screens.add(new Screen(UUID.randomUUID().toString()));

        }
    }
}

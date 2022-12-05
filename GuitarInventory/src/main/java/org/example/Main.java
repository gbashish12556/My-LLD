package org.example;

import org.example.enums.Builder;
import org.example.enums.Type;
import org.example.enums.Wood;
import org.example.model.Guitar;
import org.example.model.GuitarSpec;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        GuitarSpec guitarSpec = new GuitarSpec(Builder.FENDER,"F1",Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD, Wood.INDIAN_ROSEWOOD,6);

        List<Guitar> guitar = inventory.search(guitarSpec);

        System.out.println("SearchingGupta");

        if(guitar.size() > 0){
            System.out.println("Found a Guitar");
        }

    }

}
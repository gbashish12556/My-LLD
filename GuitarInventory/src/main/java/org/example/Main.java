package org.example;

import org.example.enums.Builder;
import org.example.enums.Type;
import org.example.enums.Wood;
import org.example.model.Guitar;

public class Main {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        initializeInventory(inventory);

    }

    static void initializeInventory(Inventory inventory){

        Guitar guitar1 = new Guitar("13123",1000, Builder.FENDER, "F1", Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD, Wood.INDIAN_ROSEWOOD);
        Guitar guitar2 = new Guitar("1312323",1100, Builder.COLLINGS, "F2", Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD, Wood.INDIAN_ROSEWOOD);
        Guitar guitar3 = new Guitar("345123",1500, Builder.FENDER, "F3", Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD, Wood.INDIAN_ROSEWOOD);
        Guitar guitar4 = new Guitar("12323",1060, Builder.MARTIN, "F4", Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD, Wood.INDIAN_ROSEWOOD);

        inventory.addGuitar(guitar1);
        inventory.addGuitar(guitar2);
        inventory.addGuitar(guitar3);
        inventory.addGuitar(guitar4);

    }

}
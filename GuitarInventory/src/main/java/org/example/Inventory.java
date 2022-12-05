package org.example;

import org.example.enums.Builder;
import org.example.enums.Type;
import org.example.enums.Wood;
import org.example.model.Guitar;
import org.example.model.GuitarSpec;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {

    private List guitars;

    public Inventory() {
        guitars = new LinkedList();
        initializeInventory();
    }

    public void addGuitar(Guitar guitar) {

        guitars.add(guitar);

    }

    public Guitar getGuitar(String serialNumber) {

        for (Iterator i = guitars.iterator(); i.hasNext(); ) {
            Guitar guitar = (Guitar) i.next();
            if (guitar.getSerialNumber().equals(serialNumber)) {
                return guitar;
            }
        }
        return null;
    }

    public List<Guitar> search(GuitarSpec searchSpec) {

        LinkedList<Guitar> searchGuitars = new LinkedList<>();

        for (Iterator i = guitars.iterator(); i.hasNext(); ) {

            Guitar guitar = (Guitar) i.next();

            GuitarSpec guitarSpec = guitar.getGuitarSpec();

            if(searchSpec.compareGuitarSpec(guitarSpec)){

                searchGuitars.add(guitar);

            }

        }

        return searchGuitars;

    }

    void initializeInventory(){

        Guitar guitar1 = new Guitar("13123",1000, new GuitarSpec(Builder.FENDER, "F1", Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD, Wood.INDIAN_ROSEWOOD,6));
        Guitar guitar2 = new Guitar("1312323",1100, new GuitarSpec(Builder.COLLINGS, "F2", Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD, Wood.INDIAN_ROSEWOOD,6));
        Guitar guitar3 = new Guitar("345123",1500,new GuitarSpec(Builder.FENDER, "F3", Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD, Wood.INDIAN_ROSEWOOD,12));
        Guitar guitar4 = new Guitar("12323",1060, new GuitarSpec(Builder.MARTIN, "F4", Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD, Wood.INDIAN_ROSEWOOD,6));

        addGuitar(guitar1);
        addGuitar(guitar2);
        addGuitar(guitar3);
        addGuitar(guitar4);

    }


}

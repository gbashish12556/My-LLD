package org.example;

import org.example.model.Guitar;
import org.example.model.GuitarSpec;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {

    private List guitars;

    public Inventory() {
        guitars = new LinkedList();
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


}

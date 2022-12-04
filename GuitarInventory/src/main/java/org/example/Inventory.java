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

    public Guitar search(Guitar searchGuitar) {

        GuitarSpec searchSpec = searchGuitar.getGuitarSpec();

        for (Iterator i = guitars.iterator(); i.hasNext(); ) {
            Guitar guitar = (Guitar) i.next();

            GuitarSpec guitarSpec = guitar.getGuitarSpec();

            if (guitarSpec.getBuilder() != searchSpec.getBuilder()) continue;

            if (!guitarSpec.getModel().equals(searchSpec.getModel())) continue;

            if (guitarSpec.getType() != searchSpec.getType()) continue;

            if (guitarSpec.getTopWood() != searchSpec.getTopWood()) continue;

            if (guitarSpec.getBackWood() != searchSpec.getBackWood()) continue;


            return guitar;
        }
        return null;

    }


}

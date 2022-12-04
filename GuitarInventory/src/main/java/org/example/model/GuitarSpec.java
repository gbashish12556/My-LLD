package org.example.model;

import org.example.enums.Builder;
import org.example.enums.Type;
import org.example.enums.Wood;

public class GuitarSpec {

    private Builder builder;
    private String model;
    private Type type;
    private Wood backWood, topWood;


    public GuitarSpec(Builder builder, String model,
                      Type type, Wood topWood, Wood backWood){

        this.builder = builder;
        this.model = model;
        this.type = type;
        this.topWood = topWood;
        this.backWood = backWood;

    }

    public Builder getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public Type getType() {
        return type;
    }

    public Wood getBackWood() {
        return backWood;
    }

    public Wood getTopWood() {
        return topWood;
    }
}

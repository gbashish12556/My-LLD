package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor

public class Ticket {

    private Integer amount;

    private Show show;
    private  List<Seat> seaNos;

}

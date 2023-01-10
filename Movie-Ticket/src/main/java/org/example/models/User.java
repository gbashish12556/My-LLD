package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.enums.SeatType;

@Getter
@AllArgsConstructor
public class User {
    private Integer id;
    private String userName;
}

package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


@Getter
@AllArgsConstructor
public class Theatre {
    Integer id;
    String name;
    List<Screen> screens;
}

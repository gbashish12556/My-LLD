package org.example.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ReadResponse {

    private String value;
    private Integer totalReadTime;

}

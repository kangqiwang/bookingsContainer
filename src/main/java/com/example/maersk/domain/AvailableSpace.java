package com.example.maersk.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvailableSpace {
    private int spaces;   
    public AvailableSpace() {
    }

    public AvailableSpace(int i) {
        this.spaces = i;
    }

    @Override
    public String toString() {
        return "AvailableSpace{" +
                "spaces=" + spaces +
                '}';
    }
}

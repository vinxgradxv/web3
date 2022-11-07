package com.example.web3_2;

import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;

@FacesConverter("initTimeConverter")
public class InitTimeConverter extends DateTimeConverter {
    public InitTimeConverter() {
        setPattern("HH:mm:ss");
    }
}

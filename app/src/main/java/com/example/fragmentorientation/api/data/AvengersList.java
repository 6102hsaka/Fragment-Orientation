package com.example.fragmentorientation.api.data;

import com.example.fragmentorientation.api.model.Avenger;

import java.util.ArrayList;
import java.util.List;

public class AvengersList {
    private static List<Avenger> avengers = new ArrayList<>();

    public static List<Avenger> getAvengers() {
        return avengers;
    }

    public static void setAvengers(List<Avenger> avengers) {
        AvengersList.avengers = avengers;
    }
}

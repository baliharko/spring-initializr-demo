package com.example.springinitializrdemo.repos;

import com.example.springinitializrdemo.models.Kompis;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class KompisDAO {

    public static List<Kompis> allKompisar = new LinkedList<>(Arrays.asList(
            new Kompis(1, "Bali", "Adress 1", "812312328"),
            new Kompis(2, "Malin", "Adress 2", "3281111111"),
            new Kompis(3, "Robin1", "Adress 3", "978345435789"),
            new Kompis(4, "Robin2", "Adress 4", "2342123"),
            new Kompis(5, "Frodo", "Adress 5", "2343333333"),
            new Kompis(6, "Vader", "Adress 6", "8787878788"),
            new Kompis(7, "Fågeln", "Adress 7", "999999999999")
    ));

    public static List<Kompis> getAllKompisar() {
        return allKompisar;
    }
}

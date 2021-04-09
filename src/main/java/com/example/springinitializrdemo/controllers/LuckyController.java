package com.example.springinitializrdemo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class LuckyController {

    @RequestMapping("/")
    public static String index() {
        return "<h1>Hellurr</h1>";
    }

    private static int randomNum() {
        Random rand = new Random();
        return rand.nextInt(10) + 1;
    }

    private static String randomAnimal() {
        List<String> animals = Arrays.asList("Hund", "Katt", "Skata", "Uggla", "Häst");
        Random rand = new Random();
        return animals.get(rand.nextInt(animals.size()));
    }

    @RequestMapping(value = "/luckyYou")
    public static String luckyYou(
            @RequestParam String luckyYou,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName
    ) {

        String fullName = "";
        if (firstName != null)
                fullName += firstName;
        if (lastName != null)
            fullName += " " +lastName;

        return luckyYou.equalsIgnoreCase("animal") ? fullName + " ditt lyckodjur är " + randomAnimal() :
                luckyYou.equalsIgnoreCase("number") ? fullName + " ditt lyckonummer är " + randomNum() : "";
    }

    @RequestMapping("/pathParam/{name}")
    public static String pathParam(@PathVariable String name) {
        return "Hej " + name;
    }
}

package com.example.springinitializrdemo.controllers;

import com.example.springinitializrdemo.models.Kompis;
import com.example.springinitializrdemo.models.Response;
import com.example.springinitializrdemo.repos.KompisDAO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
public class KompisController {

    @RequestMapping("/kompis")
    public Kompis getOneKompis() {
        Random rand = new Random();
        return KompisDAO.getAllKompisar().get(rand.nextInt(KompisDAO.getAllKompisar().size()));
    }

    @RequestMapping("/kompisar")
    public List<Kompis> getAllKompisar() {
        return KompisDAO.getAllKompisar();
    }

    @RequestMapping("/kompis/{id}")
    public Kompis getKompisById(@PathVariable int id) {
        return KompisDAO.getAllKompisar()
                .stream()
                .filter(kompis -> kompis.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @RequestMapping("/kompis/{id}/delete")
    public String deleteKompisById(@PathVariable int id) {
        if (KompisDAO.getAllKompisar().stream().anyMatch(kompis -> kompis.getId() == id)) {
            KompisDAO.getAllKompisar().removeIf(kompis -> kompis.getId() == id);
            return "Kompis with id " + id + " has been deleted.";
        }
        return "Kompis not found... Nothing removed.";
    }

    @PostMapping("/kompis/add")
    public Response addKompis(@RequestBody Kompis k) {
        KompisDAO.getAllKompisar().add(k);
        return new Response(true, "Kompis added successfully");
    }

    @PostMapping("/kompis/upsert")
    public Response upsertKompis(@RequestBody Kompis k) {

        for (int i = 0; i < KompisDAO.getAllKompisar().size(); i++) {
            if (KompisDAO.getAllKompisar().get(i).getId() == k.getId()) {
                KompisDAO.getAllKompisar().set(i, k);
                return new Response(true, "Updated kompis with id " + k.getId());
            }
        }

        KompisDAO.getAllKompisar().add(k);
        return new Response(true, "Added new kompis with id " + k.getId());
    }
}

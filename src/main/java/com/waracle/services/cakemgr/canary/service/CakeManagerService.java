package com.waracle.services.cakemgr.canary.service;

import com.waracle.services.cakemgr.canary.model.Cake;
import com.waracle.services.cakemgr.canary.repository.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CakeManagerService {

    @Autowired
    CakeRepository repository;

    public void save(final Cake cake) {
        repository.save(cake);
    }

    public List<Cake> getAll() {
        final List<Cake> cakes = new ArrayList<>();
        repository.findAll().forEach(cake -> cakes.add(cake));
        return cakes;
    }

}

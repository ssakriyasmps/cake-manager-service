package com.waracle.services.cakemgr.canary.controller;

import com.waracle.services.cakemgr.canary.model.Cake;
import com.waracle.services.cakemgr.canary.repository.CakeRepository;
import com.waracle.services.cakemgr.canary.service.CakeManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class CakeManagerController {

    @Autowired
    private CakeManagerService cakeManagerService;

    @RequestMapping(
            value = {"/cakes" },
            method = GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cake> getAllCakes() {
        return cakeManagerService.getAll();
    }


}

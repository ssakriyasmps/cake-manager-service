package com.waracle.services.cakemgr.canary.controller;

import com.waracle.services.cakemgr.canary.model.Cake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class IndexController {

    @Autowired
    CakeManagerController cakeManagerController;

    @RequestMapping(
            value = {"/" },
            method = GET)
    public ModelAndView getAllCakes() {

        List<Cake> cakes = cakeManagerController.getAllCakes();

        Map<String, Object> params = new HashMap<>();
        params.put("cakes", cakes);

        return new ModelAndView("cakes", params);
    }

}

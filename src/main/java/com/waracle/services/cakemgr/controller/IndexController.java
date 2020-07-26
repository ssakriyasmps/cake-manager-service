package com.waracle.services.cakemgr.controller;

import com.waracle.services.cakemgr.model.Cake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    CakeManagerController cakeManagerController;

    @RequestMapping(
            value = {"/" },
            method = GET)
    public ModelAndView getAllCakes() {

        logger.info("get all cakes in human readable format incoming request");

        List<Cake> cakes = cakeManagerController.getAllCakes();

        Map<String, Object> params = new HashMap<>();
        params.put("cakes", cakes);

        return new ModelAndView("cakes", params);
    }

}

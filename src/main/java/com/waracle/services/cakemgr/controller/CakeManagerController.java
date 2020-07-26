package com.waracle.services.cakemgr.controller;

import com.waracle.services.cakemgr.model.Cake;
import com.waracle.services.cakemgr.service.CakeManagerService;
import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class CakeManagerController {

    private Logger logger = LoggerFactory.getLogger(CakeManagerController.class);

    private static final String SUCCESS_CREATE_MESSAGE = "{\"message\" : \"Successfully created cake\", \"id\": \"%d\"}";

    @Autowired
    private CakeManagerService cakeManagerService;

    @RequestMapping(
            value = {"/cakes" },
            method = GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cake> getAllCakes() {
        logger.info("get all cakes incoming request");
        return cakeManagerService.getAll();
    }

    @RequestMapping(
            value = {"/cakes" },
            method = POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addCake(final @RequestBody Cake cake) {
        logger.info("add new cake request {}", cake);
        int id = cakeManagerService.save(cake);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(String.format(SUCCESS_CREATE_MESSAGE, id));
    }
}

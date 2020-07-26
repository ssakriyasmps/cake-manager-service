package com.waracle.services.cakemgr.init;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waracle.services.cakemgr.model.Cake;
import com.waracle.services.cakemgr.service.CakeManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;

@Component
public class InitialDataLoad {

    private Logger logger = LoggerFactory.getLogger(InitialDataLoad.class);

    @Value("${init.cakes.download.url}")
    private String cakesDownloadUrl;

    @Autowired
    private CakeManagerService service;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {

        try{
            logger.info("Loading Cakes into database from {}", cakesDownloadUrl);

            URL url = new URL(cakesDownloadUrl);
            List<Cake> cakes = new ObjectMapper().readValue(url, new TypeReference<List<Cake>>() {});
            service.saveAll(cakes);

            logger.info("All Cakes loaded into database from {}", cakesDownloadUrl);

        } catch(Exception ex) {
            logger.error("Error while loading cakes into database from {}", cakesDownloadUrl);
        }

    }

}

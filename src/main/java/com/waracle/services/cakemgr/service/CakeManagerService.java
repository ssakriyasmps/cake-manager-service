package com.waracle.services.cakemgr.service;

import com.waracle.services.cakemgr.model.Cake;
import com.waracle.services.cakemgr.repository.CakeEntity;
import com.waracle.services.cakemgr.repository.CakeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CakeManagerService {

    private Logger logger = LoggerFactory.getLogger(CakeManagerService.class);

    @Autowired
    CakeRepository repository;

    public int save(final Cake cake) {
        logger.info("start saving cake {}", cake);
        CakeEntity cakeEntity = toEntity(cake);
        repository.save(cakeEntity);
        logger.info("finished saving cake {}", cake);
        return cakeEntity.getId();
    }

    public void saveAll(final List<Cake> cakes) {
        List<CakeEntity> entities = new ArrayList<>();
        for(Cake cake : cakes){
            entities.add(toEntity(cake));
        }

        repository.saveAll(entities);
    }

    public List<Cake> getAll() {
        final List<Cake> cakes = new ArrayList<>();
        repository.findAll().forEach(cakeEntity -> cakes.add(toModel(cakeEntity)));
        return cakes;
    }

    private CakeEntity toEntity(Cake cake){
        CakeEntity cakeEntity = new CakeEntity(cake.getTitle(),
                cake.getDesc(),
                cake.getImage());

        return cakeEntity;
    }

    private Cake toModel(CakeEntity cakeEntity){
        Cake cake = new Cake(cakeEntity.getTitle(),
                cakeEntity.getDescription(),
                cakeEntity.getImage());

        return cake;
    }

}

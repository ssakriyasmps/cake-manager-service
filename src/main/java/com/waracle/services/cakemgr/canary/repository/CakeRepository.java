package com.waracle.services.cakemgr.canary.repository;

import com.waracle.services.cakemgr.canary.model.Cake;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CakeRepository extends CrudRepository<Cake, Integer> {

}


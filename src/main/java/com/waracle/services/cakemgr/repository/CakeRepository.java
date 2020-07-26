package com.waracle.services.cakemgr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CakeRepository extends CrudRepository<CakeEntity, Integer> {

}


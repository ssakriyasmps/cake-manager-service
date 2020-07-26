package com.waracle.services.cakemgr.service;

import com.waracle.services.cakemgr.model.Cake;
import com.waracle.services.cakemgr.repository.CakeEntity;
import com.waracle.services.cakemgr.repository.CakeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CakeManagerServiceTest {


    @Mock
    private CakeRepository cakeRepository;


    @InjectMocks
    private CakeManagerService cakeManagerService;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave(){
        cakeManagerService.save(new Cake("a", "b", "c"));
        verify(cakeRepository).save(ArgumentMatchers.eq(new CakeEntity("a", "b", "c")));
    }

    @Test
    public void testSaveAll(){

        cakeManagerService.saveAll(getAllCakes());
        verify(cakeRepository).saveAll(ArgumentMatchers.eq(getAllCakeEntities()));
    }

    @Test
    public void testFinalAll(){


        when(cakeRepository.findAll()).thenReturn(getAllCakeEntities());

        List<Cake> actualCakes = cakeManagerService.getAll();

        assertEquals(getAllCakes(), actualCakes);

    }

    private List<CakeEntity> getAllCakeEntities(){

        List<CakeEntity> entities = new ArrayList<>();
        entities.add(new CakeEntity("a", "b", "c"));
        entities.add(new CakeEntity("x", "y", "z"));

        return entities;
    }


    private List<Cake> getAllCakes(){

        List<Cake> cakes = new ArrayList<>();
        cakes.add(new Cake("a", "b", "c"));
        cakes.add(new Cake("x", "y", "z"));

        return cakes;
    }

}

package com.dione.npserver.service;

import com.dione.npserver.dto.EntityMappingDto;
import com.dione.npserver.model.EntityMapping;
import com.dione.npserver.repository.EntityMappingRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntityMapperService {
    private final EntityMappingRepository repository;
    private EntityMappingDto entityMappingDto;

    public EntityMapperService(EntityMappingRepository repository){
        this.repository = repository;
    }

    public EntityMapping getEntity(Long id){
        EntityMapping entity = repository.findEntityMappingById(id);
        return entity;
    }
/*
    public List<EntityMappingDto> getAllDto(){
        return repository.findAll();*/
    }


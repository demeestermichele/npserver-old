package com.dione.npserver.controller;

import com.dione.npserver.dto.EntityMappingDto;
import com.dione.npserver.model.EntityMapping;
import com.dione.npserver.repository.EntityMappingRepository;
import com.dione.npserver.service.EntityMapperService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping({"/entity"})
@CrossOrigin(
    origins = {"*"}
)
public class EntityMappingController {
    @Autowired
    private EntityMappingRepository entityMappingRepository;


    public EntityMappingController() {
    }

    @GetMapping("/{id}")
    public EntityMapping findEntityMappingById(@PathVariable Long id) {
        return this.entityMappingRepository.findEntityMappingById(id);
    }
    @GetMapping("/dto/{id}")
    public EntityMappingDto EntityDTO(@PathVariable Long id) {
        EntityMapping entityMapping = entityMappingRepository.findEntityMappingById(id);
        return new EntityMappingDto(entityMapping);
    }

//FIXME this is empty
    /**
     * get a list of all Entity Mapping DTOs
     * @return
     */
    @GetMapping({"/dtolist"})
    public List<EntityMappingDto> getAllMappingDto() {
     Iterable<EntityMapping> entityMappings = entityMappingRepository.findAll();
     List<EntityMappingDto> entityMappingDtoList = new ArrayList<>();
     ModelMapper modelMapper = new ModelMapper();
     modelMapper.map(entityMappings, entityMappingDtoList);
     return entityMappingDtoList;
    }

    /**
     * list of all EntityMapping
     * @return
     */
    @GetMapping({"/list"})
    public Iterable<EntityMapping> getAll() {
        return this.entityMappingRepository.findAll();
    }


    @GetMapping({"/list/character/{id}"})
    public Iterable<EntityMapping> findByCharacterId(@PathVariable Integer id) {
        return this.entityMappingRepository.findEntityMappingsByCharacter_Id(id);
    }
    @GetMapping({"/list/chapter/{id}"})
    public Iterable<EntityMapping> findByChapter(@PathVariable Long id) {
        return this.entityMappingRepository.findEntityMappingsByChapter_Id(id);
    }
    @GetMapping({"/list/plot/{id}"})
    public Iterable<EntityMapping> findByPlot(@PathVariable Integer id) {
        return this.entityMappingRepository.findEntityMappingsByPlot_Id(id);
    }


}

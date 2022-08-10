package com.dione.npserver.controller;

import com.dione.npserver.dto.EntityMappingDto;
import com.dione.npserver.model.EntityMapping;
import com.dione.npserver.repository.EntityMappingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
     *
     * @return
     */
    @GetMapping({"/dtolist"})
    public List<EntityMappingDto> getAllMappingDto() {
        List<EntityMapping> entityMappings = entityMappingRepository.findAll();
        ModelMapper modelMapper = new ModelMapper();

        System.out.println("getalldto");
        return entityMappings
                .stream()
                .map(entityMapping -> modelMapper.map(entityMappings, EntityMappingDto.class))
                .collect(Collectors.toList());
    }
/*    @GetMapping({"/dtolist"})
    public List<EntityMappingDto> getAllMappingDto() {
        ModelMapper modelMapper = new ModelMapper();

        TypeMap<EntityMapping, EntityMappingDto> typeMap =
                modelMapper.createTypeMap(EntityMapping.class, EntityMappingDto.class);

        System.out.println("getalldto");
        typeMap.addMappings(mapper-> {
            mapper.map(EntityMapping::getId, EntityMappingDto::setId);
            mapper.map(EntityMapping::getChapter, EntityMappingDto::setChapterId);
            mapper.map(EntityMapping::getCharacter, EntityMappingDto::setCharacterId);
            mapper.map(EntityMapping::getPlot, EntityMappingDto::setPlotId);
        });
        return typeMap.getMappings().stream().map(entityMapping -> modelMapper.map(entityMappingRepository.findAll(), EntityMappingDto.class))
                .collect(Collectors.toList());
    }*/
    /**
     * list of all EntityMapping
     *
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

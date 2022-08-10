package com.dione.npserver.mapper;

import com.dione.npserver.dto.EntityMappingDto;
import com.dione.npserver.model.EntityMapping;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

public class DtoMapping {

    static void explicitMapping(){
        ModelMapper modelMapper = new ModelMapper();

        TypeMap<EntityMapping, EntityMappingDto> typeMap =
                modelMapper.createTypeMap(EntityMapping.class, EntityMappingDto.class);

        typeMap.addMappings(mapper-> {
            mapper.map(EntityMapping::getId, EntityMappingDto::setId);
            mapper.map(EntityMapping::getChapter, EntityMappingDto::setChapterId);
            mapper.map(EntityMapping::getCharacter, EntityMappingDto::setCharacterId);
            mapper.map(EntityMapping::getPlot, EntityMappingDto::setPlotId);
        });
    }
}

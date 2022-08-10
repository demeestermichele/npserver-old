package com.dione.npserver.mapper;

import com.dione.npserver.dto.EntityMappingDto;
import com.dione.npserver.model.EntityMapping;
import org.modelmapper.AbstractConverter;
import java.util.List;
import java.util.stream.Collectors;

public class ListConverter extends AbstractConverter<List<EntityMapping>, List<Long>> {


    @Override
    protected List<Long> convert(List<EntityMapping> entityMappings) {
        return entityMappings
                .stream()
                .map(EntityMapping::getId)
                .collect(Collectors.toList());
    }
}

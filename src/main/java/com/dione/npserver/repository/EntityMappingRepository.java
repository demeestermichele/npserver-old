package com.dione.npserver.repository;

import com.dione.npserver.dto.EntityMappingDto;
import com.dione.npserver.model.Character;
import com.dione.npserver.model.EntityMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntityMappingRepository extends JpaRepository<EntityMapping, Integer> {

    public EntityMapping findEntityMappingById(Long id);
    public List<EntityMapping> findEntityMappingsByCharacter_Id(Integer id);
    public List<EntityMapping> findEntityMappingsByChapter_Id(Long id);
    public List<EntityMapping> findEntityMappingsByPlot_Id(Integer id);
}

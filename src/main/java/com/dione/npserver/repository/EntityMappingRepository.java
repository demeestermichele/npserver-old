package com.dione.npserver.repository;

import com.dione.npserver.model.EntityMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EntityMappingRepository extends JpaRepository<EntityMapping, Integer> {

    public EntityMapping findEntityMappingById(Long id);

    @Query("select e from EntityMapping e where e.character.id = :id")
    public List<EntityMapping> findEntityMappingsByCharacter_Id(@Param("id") Integer id);
    @Query("select e from EntityMapping e where e.chapter.id = :id")
    public List<EntityMapping> findEntityMappingsByChapter_Id(@Param("id") Long id);
    @Query("select e from EntityMapping e where e.plot.id = :id")
    public List<EntityMapping> findEntityMappingsByPlot_Id(@Param("id") Integer id);
}

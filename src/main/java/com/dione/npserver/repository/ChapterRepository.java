package com.dione.npserver.repository;

import com.dione.npserver.model.Chapter;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChapterRepository extends CrudRepository<Chapter, Integer> {

    public Chapter findChapterById(Long id);

    public List<Chapter> findChaptersByNameContaining(String name);

    public Chapter findChaptersByNumber(float number);


//    public List<Chapter> findChaptersByEntityMappingContaining(Set<EntityMapping> entityMapping);

/*    public List<Chapter> findChaptersByEntityMapping(Set<EntityMapping> entityMapping);

    public Chapter findChapterByEntityMapping(Set<EntityMapping> entityMapping);

    public Chapter findChapterByEntityMappingId(Long entityMapping_id);*/
}

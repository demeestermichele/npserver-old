package com.dione.npserver.repository;

import com.dione.npserver.model.Chapter;
import com.dione.npserver.model.Character;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface ChapterRepository extends CrudRepository<Chapter, Integer> {

    public Chapter findChapterById(Integer id);
    public List<Chapter> findChaptersByNameContaining(String name);
    public Chapter findChaptersByNumber(float number);
//    public List<Chapter> findChaptersByCharactersListContaining(List<Character> charactersList);

}

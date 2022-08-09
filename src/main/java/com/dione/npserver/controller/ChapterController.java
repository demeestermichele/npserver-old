package com.dione.npserver.controller;

import com.dione.npserver.model.Chapter;
import com.dione.npserver.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chapters")
@CrossOrigin(origins = "*")
public class ChapterController {

    @Autowired
    private ChapterRepository chapterRepository;

    @PostMapping("/add")
    public String addChapter(@RequestParam String name, @RequestParam float number, @RequestParam String description) {
        Chapter chapter = new Chapter();
        chapter.setName(name);
        chapter.setNumber(number);
        chapter.setDescription(description);
        chapterRepository.save(chapter);
        return "Chapter added!";
    }

    @GetMapping("/list")
    public Iterable<Chapter> getChapters() {
        return chapterRepository.findAll();
    }

    @GetMapping("/{id}")
    public Chapter findChapterById(@PathVariable Integer id) {
        return chapterRepository.findChapterById(id);
    }

    @GetMapping("/{number}")
    public Chapter findChapterByNumber(@PathVariable float number) {
        return chapterRepository.findChaptersByNumber(number);
    }

    @GetMapping("/{name}")
    public Iterable<Chapter> findChapterByName(@PathVariable String name){
        return chapterRepository.findChaptersByNameContaining(name);
    }

    @GetMapping("/{character}")
    public List<Chapter> findChapterByCharacterListContaining(@PathVariable List<Character> character){
        return chapterRepository.findChaptersByCharactersListContaining(character);
    }
}

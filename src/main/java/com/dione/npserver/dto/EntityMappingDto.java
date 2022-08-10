package com.dione.npserver.dto;

import com.dione.npserver.model.Chapter;
import com.dione.npserver.model.Character;
import com.dione.npserver.model.EntityMapping;
import com.dione.npserver.model.Plot;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class EntityMappingDto {

    private Long id;
    private Integer characterId;
    private Long chapterId;
    private Integer plotId;

    public EntityMappingDto(EntityMapping entityMapping) {
        this.id = entityMapping.getId();
        this.characterId = entityMapping.getCharacter().getId();
        this.chapterId = entityMapping.getChapter().getId();
        this.plotId = entityMapping.getPlot().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    public Integer getPlotId() {
        return plotId;
    }

    public void setPlotId(Integer plotId) {
        this.plotId = plotId;
    }
}

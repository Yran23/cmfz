package com.baizhi.impl;

import com.baizhi.entity.Chapter;
import com.baizhi.mapper.ChapterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class ChapterServiceImpl {
    @Autowired
    private ChapterMapper chapterMapper;

    public void addChapter(Chapter chapter) {
        chapter.setId(UUID.randomUUID().toString().replace("-", ""));
        chapterMapper.insert(chapter);
    }
}

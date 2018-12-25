package com.baizhi.impl;

import com.baizhi.entity.Chapter;
import com.baizhi.mapper.ChapterMapper;
import com.baizhi.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;

    public void addChapter(Chapter chapter) {
        System.out.println(chapter);
        chapterMapper.insert(chapter);
    }
}

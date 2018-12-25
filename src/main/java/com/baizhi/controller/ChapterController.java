package com.baizhi.controller;


import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;


@RestController
@RequestMapping("chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/addChapter")
    public void addChapter(String title, MultipartFile audio, HttpServletRequest request, Integer parent_id) {
        Chapter chapter = new Chapter();
        chapter.setTitle(title);
        chapter.setId(UUID.randomUUID().toString().replace("-", ""));
        chapter.setSize(audio.getSize());
        chapter.setUploadDate(new Date());
        chapter.setParentId(parent_id);
        //获取当前文件的保存路径
        String realPath = request.getSession().getServletContext().getRealPath("/");
        String dir = realPath + "audio";
        File file = new File(dir);
        if (!file.exists()) {
            file.mkdir();
        }
        //重命名  测试.mp3
        String originalFilename = audio.getOriginalFilename();
        //mp3
        String extension = FilenameUtils.getExtension(originalFilename);
        String newName = UUID.randomUUID().toString();
        newName = newName + "." + extension;
        chapter.setUrl(newName);
        //上传
        try {
            audio.transferTo(new File(dir, newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        chapterService.addChapter(chapter);
    }

}

package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;


@RestController
@RequestMapping("chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/addChapter")
    @ResponseBody
    public void addChapter(Chapter chapter, HttpServletRequest request, MultipartFile multipartFile) throws Exception {
        String oldName = multipartFile.getOriginalFilename();
        String newName = "/audio/" + UUID.randomUUID().toString().replace("-", "") + oldName;
        String path = request.getRealPath(newName);
        multipartFile.transferTo(new File(path));

    }

}

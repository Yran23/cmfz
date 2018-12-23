package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("/queryAllAlbum")
    @ResponseBody
    public List<Album> queryAllAlbum() {
        return albumService.queryAllAlbum();
    }

    @RequestMapping("/addAlbum")
    @ResponseBody
    public void addAlbum(Album album, MultipartFile multipartFile, HttpServletRequest request) throws Exception {
        String oldName = multipartFile.getOriginalFilename();
        String newName = "/shouye/" + UUID.randomUUID().toString().replace("-", "") + oldName;
        String path = request.getRealPath(newName);
        multipartFile.transferTo(new File(path));
        album.setCoverImg(newName);
        album.setPubDate(new Date());
        albumService.addAlbum(album);
    }
}

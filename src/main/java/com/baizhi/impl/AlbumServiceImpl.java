package com.baizhi.impl;

import com.baizhi.entity.Album;
import com.baizhi.mapper.AlbumMapper;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumMapper albumMapper;

    public List<Album> queryAllAlbum() {
        return albumMapper.queryAllAlbum();
    }

    public void addAlbum(Album album) {
        albumMapper.insert(album);
    }
}

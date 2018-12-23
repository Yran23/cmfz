package com.baizhi.impl;

import com.baizhi.entity.Banner;
import com.baizhi.mapper.BannerMapper;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;

    public List<Banner> selectAllBanner() {
        return bannerMapper.selectAll();
    }

    public void addBanner(Banner banner) {
        bannerMapper.insert(banner);
    }

    public void deleteBanner(Banner banner) {
        bannerMapper.delete(banner);
    }

    public void updateStatus(Banner banner) {
        bannerMapper.updateStatus(banner);
    }
}

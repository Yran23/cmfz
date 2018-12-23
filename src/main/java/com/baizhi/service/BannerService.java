package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.List;

public interface BannerService {
    void addBanner(Banner banner);

    List<Banner> selectAllBanner();

    void deleteBanner(Banner banner);

    void updateStatus(Banner banner);
}

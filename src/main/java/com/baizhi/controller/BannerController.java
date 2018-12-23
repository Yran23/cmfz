package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;


@RestController
@RequestMapping("banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("/selectAllBanner")
    @ResponseBody
    public List<Banner> selectAllBanner() {
        List<Banner> banners = bannerService.selectAllBanner();
        return banners;
    }

    @RequestMapping("/addBanner")
    @ResponseBody
    public String addBanner(Banner banner, MultipartFile file) throws Exception {
        String fileName = file.getOriginalFilename();
        banner.setImgPath(fileName);
        banner.setStatus("n");
        bannerService.addBanner(banner);
        //要传的路径
        String filePath = "D:\\LastProject\\cmfz\\cmfz\\src\\main\\webapp\\shouye";
        File dest = new File(filePath + "/" + fileName);
        file.transferTo(dest);
        return "";
    }

    @RequestMapping("/deleteBanner")
    @ResponseBody
    public void deleteBanner(Banner banner) {
        bannerService.deleteBanner(banner);
    }

    @RequestMapping("/updateStatus")
    @ResponseBody
    public void updateStatus(Banner banner) {
        bannerService.updateStatus(banner);
    }
}

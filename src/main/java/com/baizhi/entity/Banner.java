package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Banner implements Serializable {
    @Id
    private Integer id;
    private String title;
    @Column(name = "img_path")
    private String imgPath;
    private String status;
    @Column(name = "pub_date")
    private Date pubDate;
    private String description;

}

package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("album")
public class Album {
    private Long albumId;
    private String albumName;
    private Date publicationDate;
    private String cover;
    private Integer number;
}

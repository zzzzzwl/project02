package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("music_detail")
public class Music {
    @TableId(type = IdType.AUTO)
    private Long musicId;
    private String songTitle;
    private String albumName;
    private Date publicationDate;
    private String lyricist;
    private String composer;
    private String arranger;

}

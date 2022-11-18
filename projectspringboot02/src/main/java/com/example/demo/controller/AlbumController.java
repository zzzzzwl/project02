package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.mapper.AlbumMapper;
import com.example.demo.pojo.Album;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/album")
public class AlbumController {
    @Resource
    AlbumMapper albumMapper;

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "20") Integer pageSize,
                              @RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<Album> wrapper = Wrappers.<Album>lambdaQuery();
        if (StringUtils.isNotBlank(search)){
            wrapper.like(Album::getAlbumName,search);
        }

        Page<Album> albumPage = albumMapper.selectPage(new Page<>(pageNum, pageSize),
                wrapper);

        return Result.success(albumPage);


    }

    @PostMapping
    public Result<?> save(@RequestBody Album album){
        albumMapper.insert(album);
        return Result.success();
    }

    @PutMapping
    public Result<?> update(@RequestBody Album album){
        albumMapper.updateById(album);
        return Result.success();


    }

    @DeleteMapping("/albumId")
    public Result<?> delete(@PathVariable Long albumId ){
        albumMapper.deleteById(albumId);
        return Result.success();

    }

}
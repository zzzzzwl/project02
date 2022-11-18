package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.mapper.MusicMapper;
import com.example.demo.pojo.Music;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/music")
public class MusicController {
    @Resource
    MusicMapper musicMapper;

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<Music> wrapper = Wrappers.<Music>lambdaQuery();
        if (StringUtils.isNotBlank(search)){
            wrapper.like(Music::getSongTitle,search);
        }

        Page<Music> musicPage = musicMapper.selectPage(new Page<>(pageNum, pageSize),
                wrapper);
        return Result.success(musicPage);
    }

    @PostMapping
    public Result<?> save(@RequestBody Music music){
        musicMapper.insert(music);
        return Result.success();
    }

    @PutMapping
    public Result<?> update(@RequestBody Music music){
        musicMapper.updateById(music);
        return Result.success();


    }

    @DeleteMapping("/musicId")
    public Result<?> delete(@PathVariable Long musicId ){
        musicMapper.deleteById(musicId);
        return Result.success();

    }
    @GetMapping("/recommend")
    public Result<?> recommend(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize
                              ){
        LambdaQueryWrapper<Music> wrapper = Wrappers.<Music>lambdaQuery();
        Page<Music> musicPage = musicMapper.selectPage(new Page<>(pageNum, pageSize),
                wrapper);
        return Result.success(musicPage);
    }

}

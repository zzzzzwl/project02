package com.example.demo.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.example.demo.common.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {
    @Value("${server.port}")
    private String port;

    private static final String ip = "http://localhost";


    @PostMapping("/upload")
    @CrossOrigin//跨域
    public Result<?> upload(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        //定义文件唯一标识
        String flag = IdUtil.fastSimpleUUID();
        String rootFilePath = System.getProperty("user.dir")+"/projectspringboot02/src/main/resources/files/pictures/"+flag+"_"+originalFilename;
        FileUtil.writeBytes(file.getBytes(),rootFilePath);
        return Result.success(ip+":"+port+"/files/upload/"+flag);
    }

    @GetMapping("/music/{flag}")
    public Result<?> getFiles(HttpServletResponse response, @PathVariable String flag){
        OutputStream os;  // 新建一个输出流对象
        String basePath = System.getProperty("user.dir") + "/projectspringboot02/src/main/resources/files/music/";  // 定于文件上传的根路径
        List<String> fileNames = FileUtil.listFileNames(basePath);  // 获取所有的文件名称
        String fileName = fileNames.stream().filter(name -> name.contains(flag)).findAny().orElse("");  // 找到跟参数一致的文件
        try {
            if (StrUtil.isNotEmpty(fileName)) {
                response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
                response.setContentType("application/octet-stream");
                byte[] bytes = FileUtil.readBytes(basePath + fileName);  // 通过文件的路径读取文件字节流
                os = response.getOutputStream();   // 通过输出流返回文件
                os.write(bytes);
                os.flush();
                os.close();
            }else {
                return Result.error("-1","文件不存在");
            }
        } catch (Exception e) {
            System.out.println("文件下载失败");
        }
        return Result.success();
    }
}

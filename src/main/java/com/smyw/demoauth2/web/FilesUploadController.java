package com.smyw.demoauth2.web;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(value = "value")
public class FilesUploadController {
    @RequestMapping(value = "/upload" , method = RequestMethod.POST)
    @ApiOperation(value = "文件上传", httpMethod = "POST", response = Boolean.class, position = 1)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "djtime", value = "单据时间", required = true, dataType = "date", paramType = "form"),
            @ApiImplicitParam(name = "file", value = "附件(支持多个上传)", dataType = "file", paramType = "form"),

    })
    public Object fileUpload(@ApiIgnore @RequestParam("file") MultipartFile[]  files  ){



        return true;
    }




}

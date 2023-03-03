package zyq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import zyq.annotation.FileParam;
import zyq.annotation.FileValid;
import zyq.model.param.FileImportParam;

/**
 * @author yanqing.zou
 * @date 2023-02-16 09:58
 * Description
 */

@RestController
@RequestMapping("/file")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @FileValid
    @PostMapping("/import")
    public Object importFile(@RequestBody @FileParam FileImportParam fileParam){
        String fileName = fileParam.getFileName();
        logger.info("FileController.importFile,fileName is :"+fileName);

        return "success";
    }
}

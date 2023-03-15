package zyq.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.UrlResource;
import org.springframework.web.bind.annotation.*;
import zyq.annotation.FileParam;
import zyq.annotation.FileValid;
import zyq.model.ConfigDTO;
import zyq.model.param.FileImportParam;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author yanqing.zou
 * @date 2023-02-16 09:58
 * Description
 */

@RestController
@RequestMapping("/file")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    private static String format = "dd-MM-yyyy HH:mm";

    private static long addTime = 8*3600*1000;

    @FileValid
    @PostMapping("/import")
    public Object importFile(@RequestBody @FileParam FileImportParam fileParam){
        String fileName = fileParam.getFileName();
        logger.info("FileController.importFile,fileName is :"+fileName);
        return "success";
    }

    public static void main(String[] args) throws IOException, ParseException {
        List<ConfigDTO> configDTOS = exportFromExcel("https://testares.kktv8.com/meshowAdmin/1678847992063q10u635l8mn.xlsx");
        String string = new Gson().toJson(configDTOS);
        System.out.println(string);
    }


    public  static List<ConfigDTO> exportFromExcel(String url) throws IOException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        List<ConfigDTO> list = new ArrayList<>();
        InputStream inputStream = new UrlResource(url).getInputStream();
        XSSFWorkbook xssfSheets = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = xssfSheets.getSheetAt(0);
        logger.info("excel表格总长为："+sheet.getLastRowNum());
        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()) {
            ConfigDTO configDTO = new ConfigDTO();
            configDTO.setPotRate(0.018);
            XSSFRow xssfRow = (XSSFRow) iterator.next();
            short lastCellNum = xssfRow.getLastCellNum();
            if(xssfRow.getRowNum() == 0){
                continue;
            }
            for(int i = 0; i < lastCellNum ;i++){
                String value = xssfRow.getCell(i).toString();
                if(StringUtils.isEmpty(value)){
                    break;
                }
                switch (i){
                    case 0:
                        int index = (int) Double.parseDouble(value);
                        configDTO.setIndex(index);
                        break;
                    case 1:
                        Date startTime = sdf.parse(value);
                        configDTO.setStartTime(startTime.getTime()+addTime);
                        break;
                    case 2:
                        Date endTime = sdf.parse(value);
                        configDTO.setEndTime(endTime.getTime()+addTime);
                        break;
                    case 3:
                        Date playStartTime = sdf.parse(value);
                        configDTO.setPlayStartTime(playStartTime.getTime()+addTime);
                        break;
                    case 4:
                        Date playEndTime = sdf.parse(value);
                        configDTO.setPlayEndTime(playEndTime.getTime()+addTime);
                        break;
                    default:
                        logger.info("error*******************************");
                }
            }
            if(ObjectUtils.isNotEmpty(configDTO)){
                list.add(configDTO);
            }
        }

        return list;
    }


}

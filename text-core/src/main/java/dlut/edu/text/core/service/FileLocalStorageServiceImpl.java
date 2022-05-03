package dlut.edu.text.core.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import dlut.edu.text.common.consts.ApplicationValues;
import dlut.edu.text.common.utils.BaseFileUtils;
import dlut.edu.text.common.utils.LogUtils;

import dlut.edu.text.service.result.DetectionResultDTO;
import dlut.edu.text.service.service.FileLocalStorageService;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/15 11:38
 */
@Slf4j
@Service
public class FileLocalStorageServiceImpl implements FileLocalStorageService {
    
    @Autowired
    private ApplicationValues applicationValues;
    
    @Override
    public <T> T fileRead(Class<T> clazz, String filePath) {
    
        File file= new File(filePath);
        try {
            String json = FileUtils.readFileToString(file, "utf-8");
            return JSON.parseObject(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public String resultStorage(DetectionResultDTO result,String originFileName) {
        String json = JSON.toJSONString(result,
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);
        LocalDate date = LocalDate.now();
        String dateFormat = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        // 文件存储路径
        String fileDir = applicationValues.getResultPath() + dateFormat;
        File dir = new File(fileDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss-");
        String createTime = dateTimeFormatter.format(LocalDateTime.now());
        String filePath = fileDir + File.separator + createTime + originFileName + ".json";
        try {
            File file = new File(filePath);
            // 创建文件
            file.createNewFile();
            // 写入文件
            Writer write = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
            write.write(json);
            write.flush();
            write.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath;
    }
    
    @Override
    public String fileStorageToBeDetected(MultipartFile file) {
        try {
            //String rootPath = this.getClass().getClassLoader().getResource("").getPath();
            String rootPath = applicationValues.getFilePath();
            LocalDate date = LocalDate.now();
            String dateFormat = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
            // 文件存储路径
            String fileDir = rootPath + dateFormat;
            File dir = new File(fileDir);
            
            if (!dir.exists()) {
                dir.mkdirs();
            }
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss-");
            String createTime = dateTimeFormatter.format(LocalDateTime.now());
            String filePath = fileDir + File.separator + createTime + file.getOriginalFilename();
            File savedFile = new File(filePath);
            file.transferTo(savedFile);
            LogUtils.info(log, "文件写入成功，路径为：{0}", new Object[]{savedFile.getPath()});
            return savedFile.getPath().replace('\\', '/');
        } catch (IOException e) {
            LogUtils.error(log, e, "文件写入失败");
        }
        return null;
    }
    
    @Override
    public void fileStorageToBeRules(Long areaCode, MultipartFile... files) {
        try {
            
            String rootPath = applicationValues.getRootPath();
            String fileDir = rootPath + BaseFileUtils.getRuleFileDir(areaCode);
            File dir = new File(fileDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            
            List<String> fileNames = Arrays.stream(files)
                    .map(MultipartFile::getOriginalFilename)
                    .map(originalFimeName -> fileDir + originalFimeName)
                    .collect(Collectors.toList());
            
            for (MultipartFile file : files) {
                File savedFile = new File(fileDir + file.getOriginalFilename());
                file.transferTo(savedFile);
                LogUtils.info(log, "文件写入成功，路径为：{0}", new Object[]{savedFile.getPath()});
            }
            
        } catch (IOException e) {
            LogUtils.error(log, e, "文件写入失败");
        }
    }
    
}

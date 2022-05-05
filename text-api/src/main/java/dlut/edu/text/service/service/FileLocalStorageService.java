package dlut.edu.text.service.service;

import dlut.edu.text.service.result.DetectionResultDTO;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/15 11:30
 */
public interface FileLocalStorageService {
    /**
     * 待检测文件上传
     *
     * @param file 上传的文件
     * @return File 文件
     */
    String fileStorageToBeDetected(MultipartFile file);

    /**
     * 规则文件上传
     *
     * @param areaCode 地区码
     * @param files    文件
     * @return
     */
    String fileStorageToBeRules(Long areaCode, MultipartFile files);
    
    /**
     * 合规性检测结果保存
     * @param result 结果
     * @param originFileName 原检测文件名称
     * @return
     */
    String resultStorage(DetectionResultDTO result,String originFileName);
    
    <T> T fileRead(Class<T> clazz,String filePath);
}

package dlut.edu.text.service.service;

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
    void fileStorageToBeRules(Long areaCode, MultipartFile... files);
}

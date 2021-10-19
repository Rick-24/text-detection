package dlut.edu.textdetection.controller;

import dlut.edu.textdetection.service.TextDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("text/detection")
public class TextDetectionController {

    @Autowired
    TextDetectionService textDetectionService;

    @RequestMapping("text")
    public String textDetect(String text) {
        validate(text);
        textDetectionService.process(text);

        // todo 返回有意义的结果
        return text;
    }



    @RequestMapping("file")
    public String fileDetect(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                // 文件存放服务端的位置
                String rootPath = "d:/tmp";
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                // 写文件到服务器
                File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
                file.transferTo(serverFile);
                return "You successfully uploaded file=" + file.getOriginalFilename();
            } catch (Exception e) {
                return "You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + file.getOriginalFilename() + " because the file was empty.";
        }
    }

    /**
     * 请求入参前置校验
     * @param text
     */
    private void validate(String text) {
        // 校验逻辑
    }

}


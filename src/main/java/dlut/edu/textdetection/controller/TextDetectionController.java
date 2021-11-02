package dlut.edu.textdetection.controller;

import dlut.edu.textdetection.model.enums.GlobalErrorCode;
import dlut.edu.textdetection.model.model.result.DetectionResultDTO;
import dlut.edu.textdetection.model.result.InvokeResult;
import dlut.edu.textdetection.service.TextDetectionService;
import dlut.edu.textdetection.utils.InvokeResultUtils;
import dlut.edu.textdetection.utils.LogUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@RestController
@Slf4j
@RequestMapping("text/detection")
public class TextDetectionController {

    @Autowired
    TextDetectionService textDetectionService;

    @RequestMapping("text")
    public InvokeResult<DetectionResultDTO> textDetect(@RequestBody String text) {
        validate(text);
        try {
            DetectionResultDTO result = textDetectionService.process(text);
            // LogUtils.info(log,"result:",new Object[]{text});
            return InvokeResultUtils.buildSuccessInvokeResult(result);
        }catch(Exception e){
            LogUtils.error(log,e);
            return InvokeResultUtils.buildFailedInvokeResult(e);
        }
    }


    @RequestMapping("file")
    public InvokeResult<DetectionResultDTO> fileDetect(@RequestBody MultipartFile file) {

        try {
            String rootPath = this.getClass().getClassLoader().getResource("").getPath();
            LocalDate date = LocalDate.now();
            String dateFormat = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
            // 文件存储路径
            String fileDir = rootPath +File.separator+"tmp"+File.separator+dateFormat;
            File dir = new File(fileDir);

            if(!dir.exists()){
                dir.mkdirs();
            }
            String filePath = fileDir + File.separator + file.getOriginalFilename();
            File savedFile = new File(filePath);
            file.transferTo(savedFile);
            LogUtils.info(log,"文件写入成功，路径为：{0}",new Object[]{savedFile.getPath()});

            DetectionResultDTO result = textDetectionService.processLocalFile(savedFile.getPath());
            return InvokeResultUtils.buildSuccessInvokeResult(result);
        }catch(Exception e){
            return InvokeResultUtils.buildFailedInvokeResult(e);
        }
    }

    @RequestMapping("home")
    public ModelAndView textDetection(){
        return new ModelAndView("homepage");
    }
    /**
     * 请求入参前置校验
     *
     * @param text
     */
    private void validate(String text) {
        // 校验逻辑
    }

}


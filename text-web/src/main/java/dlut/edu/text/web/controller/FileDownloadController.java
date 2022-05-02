package dlut.edu.text.web.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/5/2 16:23
 */
@Controller
@RequestMapping("download")
public class FileDownloadController {
    @PostMapping("file")
    public ResponseEntity<ByteArrayResource> fileDownLoad(@RequestBody String filePath) throws UnsupportedEncodingException {
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(new File(filePath).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayResource byteArrayResource = new ByteArrayResource(bytes);
        return ResponseEntity.ok()
                .header("Access-Control-Expose-Headers", "Content-Disposition")
                .header("Content-Disposition", "attachment; filename=" + URLEncoder.encode(filePath.substring(filePath.lastIndexOf('/') + 1), "UTF-8"))
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(byteArrayResource);
    }
}

package dlut.edu.text.service.result;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/1/6 12:33
 */
@Data
public class KeyWordDetectionDTO <T>{
    private List<SentenceDTO<T>> sentenceDTOS;
    public KeyWordDetectionDTO(){
        this.sentenceDTOS = new ArrayList<SentenceDTO<T>>();
    }
}

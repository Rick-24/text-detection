package dlut.edu.text.core.convert;

import dlut.edu.text.integration.python.response.KeyWordDetectionDO;
import dlut.edu.text.service.result.KeyWordDetectionDTO;
import dlut.edu.text.service.result.SentenceDTO;
import dlut.edu.text.service.result.spec.KeyWordSpec;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/1/6 15:02
 */
public class KeyWordDetectionResultConvert {
    public static KeyWordDetectionDTO<KeyWordSpec> convert2DTO(KeyWordDetectionDO keyWordDetectionDO) {
        KeyWordDetectionDTO<KeyWordSpec> result = new KeyWordDetectionDTO<>();
        Map<String, List<dlut.edu.text.integration.python.response.spec.KeyWordSpec>> sentenceMap = keyWordDetectionDO.getKeyWordSpecs().stream().collect(Collectors.groupingBy(keyWordSpec -> keyWordSpec.getSegmentNum() + "-" + keyWordSpec.getSentenceNum()));
        for (List<dlut.edu.text.integration.python.response.spec.KeyWordSpec> keyWordSpecs : sentenceMap.values()) {
            dlut.edu.text.integration.python.response.spec.KeyWordSpec keyWordSpec = keyWordSpecs.get(0);
            // 当前匹配文本
            String text = keyWordSpec.getText();
            SentenceDTO<KeyWordSpec> sentenceDTO = new SentenceDTO<>(
                    text, keyWordSpec.getSegmentNum(), keyWordSpec.getSentenceNum());
            
            List<KeyWordSpec> keywords = keyWordSpecs.stream()
                    .map(KeyWordDetectionResultConvert::buildKeyWordSpec)
                    .collect(Collectors.toList());
            
            sentenceDTO.getSentenceSpecList().addAll(keywords);
            result.getSentenceDTOS().add(sentenceDTO);
        }
        result.setSentenceDTOS(
                result.getSentenceDTOS()
                        .stream()
                        .sorted(Comparator.comparingInt(SentenceDTO::getSegmentNum))
                        .collect(Collectors.toList()));
        return result;
    }
    
    public static KeyWordSpec buildKeyWordSpec(dlut.edu.text.integration.python.response.spec.KeyWordSpec keyWordSpec) {
        List<Integer> indexes = findIndex(keyWordSpec.getText(), keyWordSpec.getKeyWord());
        return new KeyWordSpec(keyWordSpec.getKeyWord(), indexes);
    }
    
    public static List<Integer> findIndex(String text, String keyWord) {
        if (!StringUtils.hasText(text) || !StringUtils.hasText(keyWord)) {
            return null;
        }
        int fromIndex = 0;
        List<Integer> result = new ArrayList<>();
        while (true) {
            int index = text.indexOf(keyWord, fromIndex);
            if (index == -1) {
                return result;
            }
            result.add(index);
            fromIndex = index+1;
        }
    }
    
    
}

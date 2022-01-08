package dlut.edu.text.core.convert;

import dlut.edu.text.integration.python.response.KeyWordDetectionDO;
import dlut.edu.text.service.result.KeyWordDetectionDTO;
import dlut.edu.text.service.result.SentenceDTO;
import dlut.edu.text.service.result.spec.KeyWordSpec;

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
            SentenceDTO<KeyWordSpec> sentenceDTO = new SentenceDTO<>(
                    keyWordSpec.getText(), keyWordSpec.getSegmentNum(), keyWordSpec.getSentenceNum());
            
            List<KeyWordSpec> keywords = keyWordSpecs.stream()
                    .map(spec -> new KeyWordSpec(spec.getKeyWord()))
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
    
    
}

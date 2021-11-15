package dlut.edu.textdetection.service;

import dlut.edu.textdetection.model.enums.AreaEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/14 19:18
 */
@SpringBootTest
public class RuleSearchServiceTest {
    @Autowired
    private RuleSearchService ruleSearchService;

    @Test
    public void testGetSysRuleFilePath() {
        List<String> sysRuleFilePath = ruleSearchService.getSysRuleFilePath(210211L);
        sysRuleFilePath.forEach(System.out::println);
    }

    @Test void testGetSysRuleAndAboveFilePath(){
        Map<AreaEnum, List<String>> sysRuleAndAboveFilePath = ruleSearchService.getSysRuleAndAboveFilePath(210211L);
        sysRuleAndAboveFilePath.entrySet().forEach(areaEnumListEntry -> {
            System.out.println(areaEnumListEntry.getKey());
            System.out.println(areaEnumListEntry.getValue());
        });
    }
}

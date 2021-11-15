package dlut.edu.textdetection.service.impl;

import dlut.edu.textdetection.dao.SysRuleDao;
import dlut.edu.textdetection.init.ApplicationValues;
import dlut.edu.textdetection.mbg.model.SysRule;
import dlut.edu.textdetection.model.enums.AreaEnum;
import dlut.edu.textdetection.service.RuleSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/14 17:52
 */
@Service
public class RuleSearchServiceImpl implements RuleSearchService {

    @Autowired
    private SysRuleDao sysRuleDao;

    @Autowired
    private ApplicationValues applicationValues;

    @Override
    public List<String> getSysRuleFilePath(Long areaCode) {
        List<SysRule> sysRules = sysRuleDao.getSysRuleByAreaCode(areaCode);
        return sysRules.stream().map(this::parseFilePath).collect(Collectors.toList());
    }

    @Override
    public Map<AreaEnum, List<String>> getSysRuleAndAboveFilePath(Long areaCode) {
        Map<AreaEnum, List<SysRule>> areaEnumListMap = sysRuleDao.getSysRuleAndAboveByAreaCode(areaCode);

        Map<AreaEnum, List<String>> result = new HashMap<>(3);
        for (Map.Entry<AreaEnum, List<SysRule>> entry : areaEnumListMap.entrySet()) {
            List<String> filePaths = entry.getValue().stream()
                    .map(this::parseFilePath)
                    .collect(Collectors.toList());
            result.computeIfAbsent(entry.getKey(), key -> new ArrayList<String>())
                    .addAll(filePaths);
        }
        return result;
    }

    private String parseFilePath(SysRule sysRule) {
        String rootPath = applicationValues.getRootPath();
        Long code = sysRule.getCode();
        String result = sysRule.getFilename();
        AreaEnum areaEnum = sysRule.parseAreaCode();
        switch (areaEnum) {
            case DISTRICT:
                result = code % 100 + "/" + result;
            case CITY:
                result = code / 100 % 100 + "/" + result;
            case PROVINCE:
                result = code / 10000 + "/" + result;
        }
        return rootPath + result;
    }
}

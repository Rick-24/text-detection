package dlut.edu.text.service.service;

import dlut.edu.text.common.consts.AreaEnum;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/13 21:59
 */
public interface RuleSearchService {

    /**
     * 获取本地区的政策文件文件路径
     * @param areaCode 地区码
     * @return
     */
    List<String> getSysRuleFilePath(Long areaCode);

    /**
     * 获取本地区及上级所有的政策文件的文件路径
     * @param areaCode 地区码
     * @return
     */
    Map<AreaEnum, List<String>> getSysRuleAndAboveFilePath(Long areaCode);
}

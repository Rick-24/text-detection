package dlut.edu.text.service.dao;


import dlut.edu.text.common.consts.AreaEnum;
import dlut.edu.text.integration.mbg.model.SysRule;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/14 16:32
 */
public interface SysRuleDao {
    /**
     * 根据地区码获取本地区级别的政策文件
     *
     * @param areaCode 地区码  例： 211000  辽宁省辽阳市
     * @return
     */
    List<SysRule> getSysRuleByAreaCode(Long areaCode);

    /**
     * 根据地区码获取本地区及上级的全部政策文件
     *
     * @param areaCode 地区码  例： 211000  辽宁省辽阳市
     * @return
     */
    Map<AreaEnum, List<SysRule>> getSysRuleAndAboveByAreaCode(Long areaCode);

    /**
     * 上传规则文件
     */
    void insertSysRule(String fileName, Long areaCode);

    /**
     * 批量上传规则文件
     */
    void insertMutipleSysRules(List<SysRule> sysRuleList);
}

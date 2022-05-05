package dlut.edu.text.service.service;

import dlut.edu.text.integration.mbg.model.SysRule;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/5/5 14:50
 */
public interface SysRuleService extends CurdService<SysRule> {

    Optional<SysRule> selectByFileName(String fileName);
}

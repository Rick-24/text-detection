package dlut.edu.text.core.service;

import dlut.edu.text.integration.mbg.mapper.SysRuleMapper;
import dlut.edu.text.integration.mbg.model.SysRule;
import dlut.edu.text.service.page.MybatisPageHelper;
import dlut.edu.text.service.page.PageRequest;
import dlut.edu.text.service.page.PageResult;
import dlut.edu.text.service.service.SysRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/5/5 14:51
 */
@Service
public class SysRuleServiceImpl implements SysRuleService {
    @Autowired
    private SysRuleMapper sysRuleMapper;
    
    @Override
    public int save(SysRule record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysRuleMapper.insertSelective(record);
        }
        return sysRuleMapper.updateByPrimaryKeySelective(record);
    }
    
    @Override
    public Optional<SysRule> selectByFileName(String fileName) {
        SysRule sysRule = sysRuleMapper.selectByFileName(fileName);
        return Optional.ofNullable(sysRule);
    }
    
    @Override
    public int delete(SysRule record) {
        sysRuleMapper.deleteByPrimaryKey(record.getId());
        return 0;
    }
    
    @Override
    public int delete(List<SysRule> records) {
        records.forEach(this::delete);
        return 0;
    }
    
    @Override
    public Optional<SysRule> findById(Long id) {
        return Optional.ofNullable(sysRuleMapper.selectByPrimaryKey(id));
    }
    
    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, sysRuleMapper);
    }
}

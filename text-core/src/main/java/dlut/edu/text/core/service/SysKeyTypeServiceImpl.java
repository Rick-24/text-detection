package dlut.edu.text.core.service;

import dlut.edu.text.integration.mbg.mapper.SysKeytypeMapper;
import dlut.edu.text.integration.mbg.mapper.SysKeywordMapper;
import dlut.edu.text.integration.mbg.model.SysKeytype;
import dlut.edu.text.integration.mbg.model.SysKeyword;
import dlut.edu.text.service.page.MybatisPageHelper;
import dlut.edu.text.service.page.PageRequest;
import dlut.edu.text.service.page.PageResult;
import dlut.edu.text.service.service.SysKeyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/1/5 13:21
 */
@Service
public class SysKeyTypeServiceImpl implements SysKeyTypeService {
    @Autowired
    private SysKeytypeMapper sysKeytypeMapper;
    @Autowired
    private SysKeywordMapper sysKeywordMapper;
    
    @Override
    public int save(SysKeytype record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysKeytypeMapper.insertSelective(record);
        }
        return sysKeytypeMapper.updateByPrimaryKeySelective(record);
    }
    
    @Override
    public int delete(SysKeytype record) {
        return sysKeytypeMapper.deleteByPrimaryKey(record.getId());
    }
    
    @Override
    public int delete(List<SysKeytype> records) {
        records.forEach(this::delete);
        return 1;
    }
    
    @Override
    public Optional<SysKeytype> findById(Long id) {
        return Optional.ofNullable(sysKeytypeMapper.selectByPrimaryKey(id));
    }
    
    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, sysKeytypeMapper);
    }
    
    @Override
    public List<SysKeytype> getByName(String name) {
        return sysKeytypeMapper.getByName(name);
    }
    
    @Override
    public List<SysKeyword> getKeyWords(Long typeId) {
        return sysKeywordMapper.getKeysByTypeId(typeId);
    }
    
    @Override
    public int saveKeyWords(List<SysKeyword> records) {
        if(records == null || records.isEmpty()) {
            return 1;
        }
        Long typeId = records.get(0).getTypeid();
        sysKeywordMapper.deleteByTypeId(typeId);
        records.forEach(sysKeywordMapper::insertSelective);
        return 1;
    }
    
    @Override
    public List<SysKeytype> getAll() {
        return sysKeytypeMapper.getAll();
    }
}

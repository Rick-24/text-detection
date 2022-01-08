package dlut.edu.text.core.service;

import dlut.edu.text.integration.mbg.mapper.SysKeytypeMapper;
import dlut.edu.text.integration.mbg.mapper.SysKeywordMapper;
import dlut.edu.text.integration.mbg.model.SysKeytype;
import dlut.edu.text.integration.mbg.model.SysKeyword;
import dlut.edu.text.service.page.MybatisPageHelper;
import dlut.edu.text.service.page.PageRequest;
import dlut.edu.text.service.page.PageResult;
import dlut.edu.text.service.service.SysKeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/1/5 13:19
 */
@Service
public class SysKeyWordServiceImpl implements SysKeywordService {
    @Autowired
    private SysKeywordMapper sysKeywordMapper;
    
    @Autowired
    private SysKeytypeMapper sysKeytypeMapper;
    
    @Override
    public SysKeyword getByValue(String value) {
        return sysKeywordMapper.getByValue(value);
    }
    
    @Override
    public List<SysKeyword> getAll() {
        List<SysKeytype> keytypes = sysKeytypeMapper.getAll();
        List<SysKeyword> keywords = sysKeywordMapper.getAll();
        keywords.forEach(keyword -> keyword.setType(keytypes.stream().filter(sysKeytype -> sysKeytype.getId().equals(keyword.getTypeid())).collect(Collectors.toList()).get(0).getValue()));
        return keywords;
    }
    
    @Override
    public int save(SysKeyword record) {
        if(record.getId() == null || record.getId()==0){
            return sysKeywordMapper.insertSelective(record);
        }
        return sysKeywordMapper.updateByPrimaryKeySelective(record);
    }
    
    @Override
    public int delete(SysKeyword record) {
        return sysKeywordMapper.deleteByPrimaryKey(record.getId());
    }
    
    @Override
    public int delete(List<SysKeyword> records) {
        records.forEach(this::delete);
        return 1;
    }
    
    @Override
    public Optional<SysKeyword> findById(Long id) {
        return Optional.ofNullable(sysKeywordMapper.selectByPrimaryKey(id));
    }
    
    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, sysKeywordMapper);
    }
}

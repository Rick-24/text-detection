package dlut.edu.text.core.service;

import dlut.edu.text.integration.mbg.mapper.SysDetectLogMapper;
import dlut.edu.text.integration.mbg.model.SysDetectLog;
import dlut.edu.text.service.page.MybatisPageHelper;
import dlut.edu.text.service.page.PageRequest;
import dlut.edu.text.service.page.PageResult;
import dlut.edu.text.service.service.SysDetectLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/5/2 20:00
 */
@Service
public class SysDetectLogServiceImpl implements SysDetectLogService {
    @Autowired
    private SysDetectLogMapper sysDetectLogMapper;
    
    @Override
    public int save(SysDetectLog record) {
        return sysDetectLogMapper.insertSelective(record);
    }
    
    @Override
    public int delete(SysDetectLog record) {
        return sysDetectLogMapper.deleteByPrimaryKey(record.getId());
    }
    
    @Override
    public int delete(List<SysDetectLog> records) {
        records.forEach(this::delete);
        return 1;
    }
    
    @Override
    public Optional<SysDetectLog> findById(Long id) {
        return Optional.ofNullable(sysDetectLogMapper.selectByPrimaryKey(id));
    }
    
    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest,sysDetectLogMapper);
    }
}

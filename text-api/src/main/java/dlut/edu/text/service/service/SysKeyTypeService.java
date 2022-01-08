package dlut.edu.text.service.service;

import dlut.edu.text.integration.mbg.model.SysKeytype;
import dlut.edu.text.integration.mbg.model.SysKeyword;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/1/5 13:20
 */
public interface SysKeyTypeService extends CurdService<SysKeytype> {
    List<SysKeytype> getByName(String name);
    
    List<SysKeyword> getKeyWords(Long typeId);
    
    int saveKeyWords(List<SysKeyword> records);
    
    List<SysKeytype> getAll();
}

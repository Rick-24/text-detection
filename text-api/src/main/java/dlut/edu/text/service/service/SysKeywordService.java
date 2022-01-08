package dlut.edu.text.service.service;

import dlut.edu.text.integration.mbg.model.SysKeyword;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/1/5 13:16
 */
public interface SysKeywordService extends CurdService<SysKeyword> {
    SysKeyword getByValue(String value);
    List<SysKeyword> getAll();
}

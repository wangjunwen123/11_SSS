package cn.WJW.xtwh.dao;

import cn.WJW.xtwh.domain.Admin;

import java.util.List;

/**
 * Created by WJW on 2019/3/21.
 */
public interface AdminDao {
    // 登陆
    public Admin login(Admin admin) throws Exception;
    public List<Admin> queryAll() throws Exception;
    public void save(Admin admin) throws Exception;
}

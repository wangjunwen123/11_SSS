package cn.WJW.xtwh.service;

import cn.WJW.xtwh.domain.Admin;

/**
 * Created by WJW on 2019/3/22.
 */
public interface AdminService {
    // 登陆
    public Admin login(Admin admin) throws Exception;

    /**
     * 加密并保存数据
     * @param admin
     * @throws Exception
     */
    public void save(Admin admin) throws Exception;
}

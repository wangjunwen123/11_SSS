package cn.WJW.xtwh.service.impl;

import cn.WJW.xtwh.dao.AdminDao;
import cn.WJW.xtwh.dao.impl.AdminDaoImpl;
import cn.WJW.xtwh.domain.Admin;
import cn.WJW.xtwh.service.AdminService;
import cn.WJW.xtwh.utils.PasswordUtils;
import org.junit.Test;

/**
 * Created by WJW on 2019/3/22.
 */
public class AdminServiceImpl implements AdminService {

    private AdminDao dao = new AdminDaoImpl();

    @Override
    public Admin login(Admin admin) throws Exception {
        // 此处加密
        String pwd = PasswordUtils.md5(admin.getPassword(),admin.getName());
        // 放回对象中
        admin.setPassword(pwd);

        return dao.login(admin);
    }

    @Override
    public void save(Admin admin) throws Exception {
        // 此处加密
        String pwd = PasswordUtils.md5(admin.getPassword(),admin.getName());
        // 放回对象中
        admin.setPassword(pwd);
        // 调dao来保存
        dao.save(admin);
    }

    @Test
    public void test1() throws Exception {
        AdminService service = new AdminServiceImpl();

        Admin admin = new Admin();
        admin.setName("WJW");
        admin.setPassword("4321");

        System.out.println(service.login(admin));
    }

    @Test
    public void test2() throws Exception {
        AdminService service = new AdminServiceImpl();

        Admin admin = new Admin();
        admin.setName("rose");
        admin.setPassword("5678");
        admin.setLimits(2);
        service.save(admin);
    }
}

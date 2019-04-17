package cn.WJW.xtwh.dao.impl;

import cn.WJW.xtwh.dao.AdminDao;
import cn.WJW.xtwh.domain.Admin;
import cn.WJW.xtwh.utils.DSUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by WJW on 2019/3/21.
 */
public class AdminDaoImpl implements AdminDao {


    @Override
    public Admin login(Admin admin) throws SQLException {
        // 1 : 声明QueryRunner对象
        QueryRunner runner = new QueryRunner(DSUtils.getDataSource());
        // 2:查询并封装
        String sql = "select * from admin where name=? and password=? limit 1";
        admin = runner.query(sql,new BeanHandler<Admin>(Admin.class),admin.getName(),admin.getPassword());
        return admin;
    }

    @Override
    public List<Admin> queryAll() throws Exception{
        QueryRunner runner = new QueryRunner(DSUtils.getDataSource());
        String sql = "select * from user";
        List<Admin> adminList = runner.query(sql, new BeanListHandler<Admin>(Admin.class));
        return adminList;
    }

    @Override
    public void save(Admin admin) throws Exception {
        QueryRunner runner = new QueryRunner(DSUtils.getDataSource());
        String sql = "insert into admin(name,password,limits) values(?,?,?)";
        runner.update(sql,admin.getName(),admin.getPassword(),admin.getLimits());
    }

    public Admin login1(Admin admin) throws SQLException {
        // 获取连接
        Connection conn = DSUtils.getConnetion();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from admin where name=? and password=? limit 1");
            // 设置参数
            ps.setString(1, admin.getName());
            ps.setString(2, admin.getPassword());
            // 执行sql
            rs = ps.executeQuery();
            if (rs.next()) {
                admin.setId(rs.getInt("id"));
                admin.setLimits(rs.getInt("limits"));
            } else {
                admin = null;
            }
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return admin;
    }

    @Test
    public void test1() throws Exception {
//        Admin admin = new Admin(0,"admin","9b2f9dd7c60267f3c0f69bc061f6cbaf",0);
        Admin admin = new Admin(0,"admin","1234",0);
        AdminDao dao = new AdminDaoImpl();
        admin = dao.login(admin);
        System.out.println(admin);
    }

    @Test
    public void test2() throws Exception {
        AdminDao dao = new AdminDaoImpl();
        System.err.println(dao.queryAll());
    }
}

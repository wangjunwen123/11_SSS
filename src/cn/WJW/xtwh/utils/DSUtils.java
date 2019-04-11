package cn.WJW.xtwh.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by WJW on 2019/3/21.
 */
public class DSUtils {
    public static DataSource ds;

    static {
        ds = new ComboPooledDataSource();
    }

    public static DataSource getDataSource(){
        return ds;
    }

    public static Connection getConnetion(){
        Connection conn;
        try {
            conn = ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    @Test
    public void test() throws Exception {

        System.out.println(DSUtils.getConnetion());

    }
}

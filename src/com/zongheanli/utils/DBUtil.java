package com.zongheanli.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @ClassName:DBUtil
 * @Description TODO  JdbcTemplate工具类
 * @author:RanMoAnRan
 * @Date:2019/5/8 18:55
 * @Version 1.0
 */

public class DBUtil {
    private static DataSource ds=new ComboPooledDataSource();

    public static JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(ds);
    }
}

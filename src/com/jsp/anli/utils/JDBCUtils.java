package com.jsp.anli.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

/**
 * @ClassName:JDBCUtils
 * @Description TODO
 * @author:RanMoAnRan
 * @Date:2019/4/29 18:06
 * @Version 1.0
 */
public class JDBCUtils {
public static DataSource ds=new ComboPooledDataSource();
public static DataSource getConnection(){
    return ds;
}
}

package com.config.util.page;

import com.config.util.global.GlobalConst;

/**
 * Created by LiNan on 2018-04-09.
 * Description: 分页工具
 */
public class PageUtil {
    /**
     * 生成mysql分页查询语句
     * @param sql
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public static String createMysqlPageSql(String sql, int pageIndex, int pageSize) {
        return sql += " limit " + (pageIndex - 1) * pageSize + "," + pageSize;
    }

    /**
     * 生成oracle分页查询语句
     * @param sql
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public static String createOraclePageSQL(String sql, int pageIndex, int pageSize) {
        return "SELECT * FROM ( SELECT A.*, ROWNUM RN FROM (" + sql + ") A WHERE ROWNUM <=" + pageIndex * pageSize + " ) WHERE RN > " + (pageIndex - 1) * pageSize;
    }

    /**
     * 生成oracle分页查询语句
     * @param sql
     * @param pageIndex
     * @return
     */
    public static String createOraclePageSQL(String sql, int pageIndex) {
        return "SELECT * FROM ( SELECT A.*, ROWNUM RN FROM (" + sql + ") A WHERE ROWNUM <=" + pageIndex * GlobalConst.pageSize + " ) WHERE RN > " + (pageIndex - 1) * GlobalConst.pageSize;
    }
}

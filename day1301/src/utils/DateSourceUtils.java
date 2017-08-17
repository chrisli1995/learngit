package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Administrator on 2017/6/26 0026.
 */
public class DateSourceUtils {
    private static ComboPooledDataSource ds=new ComboPooledDataSource();
    private static ThreadLocal<Connection> tl=new ThreadLocal<>();
    //获取数据源
    public static DataSource getDatasource(){
        return ds;
    }

    //获取连接
    //从当前线程获取链接
    public static Connection getConnection() throws SQLException {
        Connection conn=tl.get();
        if(conn==null){
            //第一次获取 创建一个连接和当前的线程绑定
            conn=ds.getConnection();
            //绑定
            tl.set(conn);
        }
        return conn;
    }

    //释放资源
    public static void closeResource(Connection conn, Statement st, ResultSet rs){
        closeResource(st, rs);
        closeConn(conn);
    }
    //释放资源
    public static void closeResource(Statement st, ResultSet rs){
        closeResultSet(rs);
        closeStatement(st);
    }
    public static void closeConn(Connection conn)  {
        if(conn!=null) {
            try {
                conn.close();
                //和当前的线程解绑
                tl.remove();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn=null;
        }
    }
    public static void closeStatement(Statement st) {
        if(st!=null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            st=null;
        }
    }
    public static void closeResultSet(ResultSet rs)  {
        if(rs!=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs=null;
        }
    }
    //开启事务
    public static void startTransaction() throws SQLException {
        //获取连接
        getConnection().setAutoCommit(false);
    }
    //事务提交
    public static void commitAndClose(){
        Connection conn = null;
        try {
            //获取连接
            conn = getConnection();
            //提交事务
            conn.commit();
            //释放资源
            conn.close();
            //接触绑定
            tl.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //事务回滚
    public static void rollbackAndClose(){
        Connection conn = null;
        try {
            //获取连接
            conn = getConnection();
            //回滚事务
            conn.rollback();
            //释放资源
            conn.close();
            //接触绑定
            tl.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

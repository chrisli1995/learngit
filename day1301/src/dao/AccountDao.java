package dao;

import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lwd on 2017/8/2.
 */
public class AccountDao {
    public void accountOut(Connection conn,String fromUser, String money) throws SQLException {
        PreparedStatement st=null;
        ResultSet rs=null;
        try {
            conn=JdbcUtils.getConnection();
            //编写sql
            String sql="update account set money=money-? where name=?";
            //编写语句执行者
            st=conn.prepareStatement(sql);
            //设置参数
            st.setString(1,money);
            st.setString(2,fromUser);
            //执行sql
            int i = st.executeUpdate();
            //处理
            System.out.println("转出结果"+i);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }finally {
            //JdbcUtils.closeResource(conn,st,rs);
            JdbcUtils.closeStatement(st);
        }
    }

    public void accountIn(Connection conn,String toUser, String money) throws SQLException {
        PreparedStatement st=null;
        ResultSet rs=null;
        try {
            conn=JdbcUtils.getConnection();
            //编写sql
            String sql="update account set money=money+? where name=?";
            //编写语句执行者
            st=conn.prepareStatement(sql);
            //设置参数
            st.setString(1,money);
            st.setString(2,toUser);
            //执行sql
            int i = st.executeUpdate();
            //处理
            System.out.println("转入结果"+i);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }finally {
            //JdbcUtils.closeResource(conn,st,rs);
            JdbcUtils.closeStatement(st);
        }
    }
}

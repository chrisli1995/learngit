package dao;

import org.apache.commons.dbutils.QueryRunner;
import utils.DateSourceUtils;

import java.sql.SQLException;

/**
 * Created by lwd on 2017/8/4.
 */
public class AccountDaoDB {
    public void accountOut(String fromUser, String money) throws SQLException {
        //创建queryrunner
        QueryRunner qr = new QueryRunner();
        //编写sql
        String sql="update account set money=money-? where name=?";
        //执行sql
        qr.update(DateSourceUtils.getConnection(),sql,money,fromUser);
    }

    public void accountIn(String toUser, String money) throws SQLException {
        QueryRunner qr=new QueryRunner();
        String sql="update account set money=money+? where name=?";
        qr.update(DateSourceUtils.getConnection(),sql,money,toUser);
    }
}

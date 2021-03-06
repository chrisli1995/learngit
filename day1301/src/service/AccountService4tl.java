package service;

import dao.AccountDao;
import dao.AccountDao4tl;
import utils.DateSourceUtils;
import utils.JdbcUtils;

import java.sql.Connection;

/**
 * Created by lwd on 2017/8/3.
 */
public class AccountService4tl {
    //转账
    public void account(String fromUser, String toUser, String money) throws Exception {
        AccountDao4tl dao=new AccountDao4tl();
        try {
            //0 开启事务
            DateSourceUtils.startTransaction();
            //1 转出
            dao.accountOut(fromUser,money);
            //int i=1/0;
            //2 转入
            dao.accountIn(toUser,money);
            //3 事务提交
            DateSourceUtils.commitAndClose();
        }catch (Exception e){
            e.printStackTrace();
            DateSourceUtils.rollbackAndClose();
            throw e;
        }

    }
}

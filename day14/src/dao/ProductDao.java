package dao;

import domain.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lwd on 2017/8/16.
 */
public class ProductDao {
    //查询所有商品
    public List<Product> findAll() throws Exception {
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from product";
        return qr.query(sql,new BeanListHandler<>(Product.class));
    }
}

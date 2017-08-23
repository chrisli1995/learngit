package dao;

import domain.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import service.ProductService;
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
    //添加商品
    public void addProduct(Product p) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql="insert into product(pid,pname,market_price,shop_price,pdate,pdesc) values(?,?,?,?,?,?)";
        qr.update(sql,p.getPid(),p.getPname(),p.getMarket_price(),p.getShop_price(),p.getPdate(),p.getPdesc());
    }
}

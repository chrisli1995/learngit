package service;
import java.sql.SQLException;
import java.util.List;

import dao.ProductDao;
import domain.Product;

/**
 * Created by lwd on 2017/8/16.
 */
public class ProductService {
    //查询所有商品
    public List<Product> findAll() throws Exception {
        return new ProductDao().findAll();
    }
}

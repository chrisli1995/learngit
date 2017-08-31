package service;
import java.sql.SQLException;
import java.util.List;

import dao.ProductDao;
import domain.PageBean;
import domain.Product;

/**
 * Created by lwd on 2017/8/16.
 */
public class ProductService {
    //查询所有商品
    public List<Product> findAll() throws Exception {
        return new ProductDao().findAll();
    }
    //添加商品
    public void addProduct(Product p) throws SQLException {
        new ProductDao().addProduct(p);
    }
    //通过ID查找商品
    public Product getProductById(String pid) throws SQLException {
        return new ProductDao().getProductById(pid);
    }
    //修改商品
    public void updateProduct(Product p) throws SQLException {
        new ProductDao().updateProductById(p);
    }
    //通过pid删除商品
    public void deleteProductById(String pid) throws SQLException {
        new ProductDao().deleteProductById(pid);
    }
    //删除多个商品
    public void deleteManyProduct(String[] ids) throws SQLException {
        ProductDao pDao=new ProductDao();
        for (String pid:ids) {
            pDao.deleteProductById(pid);

        }
    }
    //多条件查询
    public List<Product> findProductByCondition(String name, String kw) throws SQLException {
        return new ProductDao().findProductByCondition(name,kw);
    }
    //分页查询
    public PageBean<Product> showProductByPage(int currPage, int pageSize) throws SQLException {
        //查询当前页数据 limit (当前页-1)*每页显示的条数，每页显示条数
        ProductDao dao=new ProductDao();
        List<Product> list=dao.findProductByPage(currPage,pageSize);
        //查询总条数
        int totalCount=dao.getCount();
        return new PageBean<>(list,currPage,pageSize,totalCount);
    }
}

package web.servlet;

import domain.PageBean;
import domain.Product;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by lwd on 2017/8/30.
 */
public class ShowProductByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0 设置编码
        //1 获取第几页
        int currPage=Integer.parseInt(request.getParameter("currPage"));
        //固定每页显示的条数
        int pageSize=3;
        //2 调用service 完成分页查询 返回值：pagebean
        PageBean<Product> bean= null;
        try {
            bean = new ProductService().showProductByPage(currPage,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //3 将pagebean放入request域中，请求转发product_page.jsp
        request.setAttribute("pb",bean);
        request.getRequestDispatcher("/product_page.jsp").forward(request,response);
    }
}

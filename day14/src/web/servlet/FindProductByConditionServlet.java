package web.servlet;

import domain.Product;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by lwd on 2017/8/29.
 */
public class FindProductByConditionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0 设置编码
        request.setCharacterEncoding("utf-8");
        //1 接受两个参数
        String name=request.getParameter("name");
        String kw=request.getParameter("kw");
        //2 调用service 完成操作 返回值:list
        List<Product> plist= null;
        try {
            plist = new ProductService().findProductByCondition(name,kw);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //3 讲list放入request域中，请求转发
        request.setAttribute("list",plist);
        request.getRequestDispatcher("/product_list.jsp").forward(request,response);
    }
}

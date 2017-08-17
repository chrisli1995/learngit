package web.servlet;

import domain.Product;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by lwd on 2017/8/16.
 */
@WebServlet(name = "FindAllServlet")
public class FindAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 调用service 查询所有商品 返回list
        List<Product> plist= null;
        try {
            plist = new ProductService().findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //2 将list放入request域中
        request.setAttribute("list",plist);
        //3 请求转发
        request.getRequestDispatcher("/product_list.jsp").forward(request,response);
    }
}

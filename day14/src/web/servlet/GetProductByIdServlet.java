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

/**
 * Created by lwd on 2017/8/28.
 * 通过商品ID获取商品
 */
@WebServlet(name = "GetProductByIdServlet")
public class GetProductByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0 设置编码

        //1 获取商品PID
        String pid=request.getParameter("pid");
        //2 调用service 通过ID获取商品
        Product p= null;
        try {
            p = new ProductService().getProductById(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //3 将product放入request域中，请求转发到edit.jsp
        request.setAttribute("bean",p);
        request.getRequestDispatcher("/edit.jsp").forward(request,response);
    }
}

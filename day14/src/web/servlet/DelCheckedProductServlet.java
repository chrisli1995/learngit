package web.servlet;

import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by lwd on 2017/8/29.
 * 删除多个商品
 */
public class DelCheckedProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 获取商品id
        String[] ids = request.getParameterValues("pid");
        //2 调用service完成删除多个
        try {
            new ProductService().deleteManyProduct(ids);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("msg","商品删除失败");
            request.getRequestDispatcher("/msg.jsp").forward(request,response);
            return;
        }
        //3 页面重定向
        response.sendRedirect(request.getContextPath()+"/findAll");
    }
}

package web.servlet;

import domain.Product;
import org.apache.commons.beanutils.BeanUtils;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by lwd on 2017/8/28.
 * 修改商品
 */
public class EditProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0 设置编码
        request.setCharacterEncoding("utf-8");
        //1 封装数据
        Product p=new Product();
        try {
            BeanUtils.populate(p,request.getParameterMap());
            //2 调用service 完成更新
            new ProductService().updateProduct(p);
            //3 重定向FindAllServlet
            response.sendRedirect(request.getContextPath()+"/findAll");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg","修改商品出错");
            request.getRequestDispatcher("/msg.jsp").forward(request,response);
        }

    }
}

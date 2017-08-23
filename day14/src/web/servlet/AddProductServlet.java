package web.servlet;

import domain.Product;
import org.apache.commons.beanutils.BeanUtils;
import service.ProductService;
import utils.UUIDUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * Created by lwd on 2017/8/17.
 */
public class AddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0 设置编码
        request.setCharacterEncoding("utf-8");
        //扩展令牌机制
        //0.1 获取session中的令牌和提交过来的令牌
        String r_lingpai = request.getParameter("r_lingpai");
        String s_lingpai = (String) request.getSession().getAttribute("s_lingpai");
        //0.2 移除session中的令牌
        request.getSession().removeAttribute("s_lingpai");
        //0.3 比较两个令牌
        if(s_lingpai==null||!s_lingpai.equals(r_lingpai)){
            //已经提交过了 生成错误信息 放入request域中 到msg.jsp
            request.setAttribute("msg","商品已保存");
            request.getRequestDispatcher("/msg.jsp").forward(request,response);
            return;
        }
        //1 封装数据
        Product p=new Product();
        try {
            BeanUtils.populate(p,request.getParameterMap());
            //1.1 给商品设置pid
            p.setPid(UUIDUtils.getId());
            //1.2 设置时间
            p.setPdate(new Date());
            //2 调用service完成添加操作
            new ProductService().addProduct(p);
            //3 页面跳转
            //先用请求转发
            request.getRequestDispatcher("/findAll").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg","添加商品失败");
            request.getRequestDispatcher("/msg.jsp").forward(request,response);
        }

    }
}

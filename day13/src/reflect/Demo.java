package reflect;

import domain.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by lwd on 2017/8/2.
 */
public class Demo {
    @Test
    public void f1() throws Exception {
        //1、获取class对象
        Class clazz=Class.forName("domain.Person");
        //2、获取构造器（了解）
        Constructor con = clazz.getConstructor();
        Person p = (Person) con.newInstance();
        //2.1、获取带参的构造器
        Constructor con1 = clazz.getConstructor(String.class, String.class);
        Person p1 = (Person) con1.newInstance("tom", "123");//相当于new Person("tom","123")
        System.out.println(p1.getPassword());
    }
    @Test
    public void f2() throws Exception {
        //1、获取class对象
        Class clazz=Class.forName("domain.Person");
        //2、获取构造器
        Person p = (Person) clazz.newInstance();
    }
    @Test
    public void f3() throws Exception {
        //1、获取class对象
        Class clazz=Class.forName("domain.Person");
        Person p = (Person) clazz.newInstance();
        //2、获取方法
        //Method m = clazz.getMethod("sleep");//只能获取公共的方法
        Method m = clazz.getDeclaredMethod("sleep");//获取任意方法
        //2.1、若是私有的方法必须让该方法可以访问
        m.setAccessible(true);
        //执行方法
        m.invoke(p);
    }
    @Test
    public void f4() throws Exception {
        //获取class对象
        Class clazz=Class.forName("domain.Person");
        //获取私有的方法
        Method m = clazz.getDeclaredMethod("sleep", String.class);
        //让方法可以访问
        m.setAccessible(true);
        //让方法执行
        String res= (String) m.invoke(clazz.newInstance(),"康宇轩");
        System.out.println(res);
    }
}

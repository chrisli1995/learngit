package domain;

/**
 * Created by lwd on 2017/8/2.
 */
public class Person {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Person(){
        System.out.println("我是空参的构造器");
    }
    public Person(String username,String password){
        System.out.println("我是带参的构造器");
        this.username=username;
        this.password=password;
    }
    public void eat(){
        System.out.println("会吃");
    }
    public void eat(String name){
        System.out.println(name+"再吃");
    }
    private void sleep(){
        System.out.println("会睡");
    }
    private void sleep(String name){
        System.out.println(name+"再睡");
    }
}

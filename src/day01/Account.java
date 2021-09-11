package day01;

public class Account {
    String Name;
    int Age;
    ZhangHu zhanghu;

    public void Qu(int b)
    {
        if(zhanghu.Balance<b) {
            System.out.println("余额不足");
        } else{
            zhanghu.Balance-=b;
            System.out.println("成功取出"+b+"元");
            System.out.println("余额为"+zhanghu.Balance+"元");
        }

    }
    public void Cun(int b)
    {
        zhanghu.Balance+=b;
        System.out.println("成功存入"+b+"元");
    }

    public Account() {

    }

    public Account(String name, int age, ZhangHu zhanghu) {
        Name = name;
        Age = age;
        this.zhanghu = zhanghu;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public ZhangHu getZhanghu() {
        return zhanghu;
    }

    public void setZhanghu(ZhangHu zhanghu) {
        this.zhanghu = zhanghu;
    }
}

package day01;

import java.io.*;
import java.util.Scanner;

public class Bank {


    public static void ShenQing() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要设置的账号");
        String User=sc.nextLine();
        System.out.println("请输入你要设置的密码");
        String Password=sc.nextLine();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/Day01/account", true)));
        String s = User + " " + Password + " " + "0" + "\r\n";
        bw.write(s);
        bw.flush();
        bw.close();

        Bank.CaiDan();
    }

    public static void CaiDan() throws IOException {
        System.out.println("***********************银行管理系统*****************");
        System.out.println("<1>已有帐户********\n<2>申请账户");
      Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if (a == 1) {
            bank.DengLu();
        }
        else if(a==2){
            try {
                Bank.ShenQing();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("请输入有效命令");
            Bank.CaiDan();
        }

    }



    public   void DengLu() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入账号");
        String User = sc.nextLine();
        System.out.println("请输入密码");
        String Password = sc.nextLine();
        BufferedReader bis = new BufferedReader(new InputStreamReader(new FileInputStream("src/Day01/account")));
        String s;
        while ((s = bis.readLine()) != null) {

            String[] ss = s.split(" ");
            if (User.equals(ss[0]) && Password.equals(ss[1])) {
                System.out.println("登陆成功");
                ZhangHu zhangHu = new ZhangHu(User, Password, Integer.parseInt(ss[2]));
                GongNeng(zhangHu);
                break;
            }
        }
        if(s==null) {
            System.out.println("账号或密码错误,请重新输入");
            DengLu();
        }

    }

    public void GongNeng(ZhangHu zhangHu){
        Account account = new Account();
        account.setZhanghu(zhangHu);
        Scanner sc = new Scanner(System.in);
        System.out.println("<1>存钱");
        System.out.println("<2>取钱");
        System.out.println("<3>退出");

        switch (sc.nextInt())
        {
            case 1:
                System.out.println("存钱金额");
                account.Cun(sc.nextInt());
                GongNeng(zhangHu);
                break;
            case 2:
                System.out.println("取钱金额");
                account.Qu(sc.nextInt());
                GongNeng(zhangHu);
                break;
            case 3:
                try {
                    Bank.CaiDan();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;


        }
    }


}

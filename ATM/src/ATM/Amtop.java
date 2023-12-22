package ATM;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Amtop {
    //存储账户信息
    private ArrayList<Account> accounts = new ArrayList<>();

    //欢迎页
    public void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("欢迎使用ATM系统！");
            System.out.println("1.开通账户");
            System.out.println("2.登录账户");
            System.out.println("请选择系统操作：");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    create();
                    break;
                case "2":
                    if (accounts.size() > 0) {
                        Account account = load();
                        loadshow(account);
                    } else {
                        System.out.println("当前系统中无账户信息，请先创建账户！");
                    }
                    break;
                default:
                    System.out.println("您输入的命令有误，请重新输入！");
                    break;
            }
        }
    }

    //登录页面
    public void loadshow(Account account){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("========" + account.getName() + (account.getGender() == '男' ? "先生" : "女士") + ",您可以办理以下业务========");
            System.out.println("1.查询账户");
            System.out.println("2.存款");
            System.out.println("3.取款");
            System.out.println("4.转账");
            System.out.println("5.修改密码");
            System.out.println("6.退出");
            System.out.println("7.注销账户");
            System.out.println("请选择业务序号：");
            int id = sc.nextInt();
            switch (id){
                case 1:
                    select(account);
                    break;
                case 2:
                    deposit(account);
                    break;
                case 3:
                    withdrawal(account);
                    break;
                case 4:
                    if (accounts.size() > 1){
                        if (account.getMoney() > 0){
                            transfer(account);
                            break;
                        }else {
                            System.out.println("余额不足！");
                            break;
                        }
                    }else {
                        System.out.println("当前系统账户数为：" + accounts.size() + "，无法实现转账功能！");
                        break;
                    }
                case 5:
                    recode(account);
                    break;
                case 6:
                    return;
                case 7:
                    delete(account);
                    return;
                default:
                    System.out.println("您输入的命令有误！");
                    break;
            }
        }
    }

    //开通账户
    public void create() {
        Account account = new Account();
        System.out.println("========开户界面========");
        //随机生成8位卡号
        String cardid = "";
        Random rd = new Random();
        int j = 0;
        while (j > 0) {
            for (int i = 0; i < 8; i++) {
                cardid += rd.nextInt(10);
            }
            for (int i = 0; i < accounts.size(); i++) {
                Account acc = accounts.get(i);
                if (cardid.equals(acc.getCardid())){
                    j++;
                }
            }
        }
        account.setCardid(cardid);

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入姓名：");
        account.setName(sc.next());

        while (true) {
            System.out.println("请输入性别：");
            char gender = sc.next().charAt(0);
            if (gender == '男' || gender == '女') {
                account.setGender(gender);
                break;
            }
        }

        while (true) {
            System.out.println("请输入6位密码：");
            String code = sc.next();
            if (code.length() == 6){
                System.out.println("请确认密码：");
                String newcode = sc.next();
                if (newcode.equals(code)){
                    account.setCode(code);
                    break;
                }else{
                    System.out.println("两次输入密码不一致，请重新输入！");
                }
            }else{
                System.out.println("密码长度超长！");
            }
        }

        System.out.println("请输入限额：");
        account.setLimi(sc.nextInt());

        accounts.add(account);
        System.out.println(account.getName() + (account.getGender() == '男' ? "先生" : "女士") + "开户成功，卡号为：" + account.getCardid());

    }

    //登录账户
    public Account load() {
        System.out.println("========登录界面========");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入卡号：");
            String cardid = sc.next();
            for (int i = 0; i < accounts.size(); i++) {
                Account account = accounts.get(i);
                if (account.getCardid().equals(cardid)) {
                    System.out.println("登录成功！");
                    return account;
                }
            }
            System.out.println("卡号输入有误！");
        }
    }

    //查询账户
    public void select(Account account) {
        System.out.println("========当前账户信息如下========");
        System.out.println("卡号：" + account.getCardid());
        System.out.println("户主：" + account.getName());
        System.out.println("性别：" + account.getGender());
        System.out.println("余额：" + account.getMoney());
        System.out.println("限额：" + account.getLimi());
    }

    //存款
    public void deposit(Account account) {
        System.out.println("========用户存款操作========");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入存款金额：");
        int money = sc.nextInt();
        account.setMoney(account.getMoney() + money);
        System.out.println("恭喜您存款" + money + "元成功！");
    }

    //取款
    public void withdrawal(Account account) {
        System.out.println("========用户取款操作========");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入取款金额：");
        int money = sc.nextInt();
        while (account.getMoney() < money) {
            System.out.println("余额不足，您当前账户余额为：" + account.getMoney());
            System.out.println("请输入取款金额：");
            money = sc.nextInt();
        }
        while (account.getLimi() < money) {
            System.out.println("您当前的取款金额超过每次限额：" + account.getLimi() + "元");
            System.out.println("请输入取款金额：");
            money = sc.nextInt();
        }
        account.setMoney(account.getMoney() - money);
        System.out.println("恭喜您取款" + money + "元成功！");
    }

    //转账
    public void transfer(Account account) {
        System.out.println("========用户转账操作========");
        Scanner sc = new Scanner(System.in);
        System.out.println("请您输入对方账户的卡号：");
        String cardid = sc.next();
        for (int i = 0; i < accounts.size(); i++) {
            Account ac = accounts.get(i);
            if (cardid.equals(ac.getCardid())) {
                while (true) {
                    System.out.println("请您输入[*" + ac.getName().substring(1) + "]的姓氏");
                    String name = sc.next();
                    if (name.equals(ac.getName().substring(0,1))){
                        System.out.println("请输入您的转账金额：");
                        int transmoney = sc.nextInt();
                        if (transmoney <= account.getMoney()){
                            account.setMoney(account.getMoney() - transmoney);
                            ac.setMoney(ac.getMoney() + transmoney);
                            System.out.println("转账成功！");
                            return;
                        }else {
                            System.out.println("当前账户余额为：" + account.getMoney() + "，小于转账金额，无法转账！");
                        }
                    }else {
                        System.out.println("您输入的姓氏有误！");
                    }
                }
            }
        }
        System.out.println("当前系统无该账户！");
    }

    //修改密码
    public void recode(Account account) {
        System.out.println("=========用户密码修改=========");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请您输入当前密码：");
            String oldcode = sc.next();
            if (oldcode.equals(account.getCode())) {
                System.out.println("请您输入新密码：");
                String newcode1 = sc.next();
                System.out.println("请您确认密码：");
                String newcode2 = sc.next();
                if (newcode2.equals(newcode1)) {
                    account.setCode(newcode1);
                    System.out.println("恭喜您修改密码成功！");
                    return;
                }
            } else {
                System.out.println("您输入的密码不正确！");
            }
        }
    }

    //注销账户
    public void delete(Account account) {
        System.out.println("========用户销户========");
        Scanner sc = new Scanner(System.in);
        System.out.println("是否销户？y/n");
        String choice = sc.next();
        if (choice.equals("y")) {
            if (account.getMoney() == 0) {
                System.out.println("销户成功！");
                accounts.remove(account);
            } else {
                System.out.println("账户还有余额，不允许销户！");
            }
        }
    }

}

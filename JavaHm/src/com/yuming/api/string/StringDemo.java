package com.yuming.api.string;

import java.util.Scanner;

public class StringDemo {
    public static void main(String[] args) {
        // 三次循环结束/接收两个键入值且都符合要求才可结束
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入登录名：");
        String name = sc.next();
        System.out.println("请输入密码：");
        String code = sc.next();

        int i = 0;
        while (i < 2) {
            if (name.equals("itheima") && code.equals("123456")){
                System.out.println("欢迎进入系统！");
                return;
            }else if (!name.equals("itheima")){
                System.out.println("登录名错误，请重新输入：");
                name = sc.next();
            }else if (!code.equals("123456")){
                System.out.println("密码输入错误，请重新输入：");
                code = sc.next();
            }
            i += 1;
        }
        System.out.println("尝试登陆三次失败，请稍后重试！");

    }
}

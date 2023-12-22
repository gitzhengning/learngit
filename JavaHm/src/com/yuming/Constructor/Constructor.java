package com.yuming.Constructor;

import java.util.Scanner;

public class Constructor {
    public static void main(String[] args) {
        /*电影数据：
        1,"水门桥", 38.9, "徐克"
        2, "出拳吧", 39, "唐晓白"
        3,"月球陨落", 42, "罗兰"
        4,"一点就到家", 35, "许宏宇"*/
        //调用构造器 初始化电影信息
        ConMovie[] movie = new ConMovie[4];
        movie[0] = new ConMovie(1,"水门桥", 38.9, "徐克");
        movie[1] = new ConMovie(2, "出拳吧", 39, "唐晓白");
        movie[2] = new ConMovie(3,"月球陨落", 42, "罗兰");
        movie[3] = new ConMovie(4,"一点就到家", 35, "许宏宇");

        // 展示电影信息，1展示全部信息，2按id查询
        Scanner sc = new Scanner(System.in);
        ConMovieOP movieop = new ConMovieOP(movie);
        while (true) {
            System.out.println("请输入查询内容（全部电影信息-1，按id查询电影信息-2）：");
            int s = sc.nextInt();
            switch (s){
                case 1:
                    movieop.printall();
                    break;
                case 2:
                    System.out.println("请输入需查询的电影编号：");
                    int id = sc.nextInt();
                    movieop.printid(id);
                    break;
                default:
                    System.out.println("不存在此id电影信息！");
            }
        }


    }
}

package com.yuming.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo2operate {
    private ArrayList<Food> foodlist = new ArrayList<>();

    public Demo2operate() {
    }

    public Demo2operate(ArrayList<Food> foodlist) {
        this.foodlist = foodlist;
    }

    public ArrayList<Food> getFoodlist() {
        return foodlist;
    }

    public void setFoodlist(ArrayList<Food> foodlist) {
        this.foodlist = foodlist;
    }

    //添加菜品
    public void create() {
        Food food = new Food();
        Scanner sc = new Scanner(System.in);

            System.out.println("请输入菜品名称：");
            String name = sc.next();
            food.setName(name);

            System.out.println("请输入菜品描述：");
            String mesg = sc.next();
            food.setMesg(mesg);

            System.out.println("请输入菜品价格：");
            double price = sc.nextDouble();
            food.setPrice(price);

            foodlist.add(food);
    }

    //展示菜品
    public void showfood(){
        if (foodlist.size() == 0){
            System.out.println("暂无可展示信息，请先上架菜品。");
        }
        System.out.println("各菜品详细信息：");
        for (int i = 0; i < foodlist.size(); i++) {
            System.out.print("菜品名称：");
            System.out.println(foodlist.get(i).getName());
            System.out.print("菜品详情：");
            System.out.println(foodlist.get(i).getMesg());
            System.out.print("菜品价格：");
            System.out.println(foodlist.get(i).getPrice());
            System.out.println("-----------------");
        }
    }

    //界面展示
    public void start(){
        Scanner sc = new Scanner(System.in);
        String type;
        while (true) {
            System.out.println("请输入操作指令：（1-上架，2-展示，3-退出）");
            type = sc.next();
            switch (type) {
                case "1":
                    create();
                    break;
                case "2":
                    showfood();
                    break;
                case "3":
                    System.out.println("退出系统！");
                    return;
                default:
                    System.out.println("输入指令有误！");
                    break;
            }
        }
    }

}

package com.yuming.api.string;

import java.util.Random;

public class StringDemo2 {
    public static void main(String[] args) {
        String code = createcode();
        System.out.println(code);
    }

    public static String createcode(){
        Random rd = new Random();
        //声明验证码
        String code = "";
        //数据范围
        String data = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        //位数随机
        int codelength = rd.nextInt(4,5);

        for (int i = 0; i < codelength; i++) {
//            int datacode = rd.nextInt(62);
            int datacode = rd.nextInt(data.length());
            code += data.charAt(datacode);
        }

        return code;

    }
}

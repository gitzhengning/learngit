package com.yuming.api.string;

public class string {
    public static void main(String[] args) {
        byte[] bytes = {97,98,99};
        String s1 = new String(bytes);
        System.out.println(s1);
        String s2 = "Hello";
        System.out.println(s2);
        String s4 = "Hello";
        String s5 = "hello";

        System.out.println(s1.length());

        System.out.println(s1.charAt(0));

        char[] s3 = s2.toCharArray();
        System.out.println(s3[0]);

        boolean b = s2.equals(s1);
        System.out.println("布尔" + b);
        System.out.println(s2.equals(s4));
        System.out.println(s2.equals(s3));

        System.out.println(s2.equalsIgnoreCase(s5));

        System.out.println(s2.substring(2,4));

        System.out.println(s2.substring(1));

        String rs = s2.replace('H','h'); //替换后，生成新字符串
        System.out.println(rs);
        System.out.println(s2);

        System.out.println(s2.contains("ll"));
        System.out.println(s2.contains("ab"));

        System.out.println(s2.startsWith("H"));

        String[] splits2 = s2.split("ll"); //分割字符在源字符串中重复时，分割规则？
        System.out.println(splits2[0] + "," + splits2[1]);




    }
}

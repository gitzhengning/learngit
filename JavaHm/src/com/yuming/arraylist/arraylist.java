package com.yuming.arraylist;

import java.util.ArrayList;

public class arraylist {
    public static void main(String[] args) {
        ArrayList<String> arrayList= new ArrayList<>();
        arrayList.add("第一个");
        arrayList.add("第二个");
        System.out.println(arrayList);
        arrayList.add(0,"第一个插入");
        System.out.println(arrayList);
        System.out.println(arrayList.get(2));
        System.out.println(arrayList.size());
        System.out.println(arrayList.remove(0));
        System.out.println(arrayList);
        System.out.println(arrayList.remove("第二个"));
        System.out.println(arrayList);
        System.out.println(arrayList.set(0,"修改第一个"));
        System.out.println(arrayList);

    }
}

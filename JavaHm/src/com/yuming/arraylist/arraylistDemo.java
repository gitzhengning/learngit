package com.yuming.arraylist;

import java.util.ArrayList;

public class arraylistDemo {
    public static void main(String[] args) {
        ArrayList<String> buycar = new ArrayList<>();
        buycar.add("Java入门");
        buycar.add("宁夏枸杞");
        buycar.add("黑枸杞");
        buycar.add("人字拖");
        buycar.add("特级枸杞");
        buycar.add("枸杞子");
        System.out.println(buycar);

        //批量删除
        for (int i = 0; i < buycar.size(); i++) {
            String product = buycar.get(i);
            if (product.contains("枸杞")){
                buycar.remove(i);
                i -= 1;
            }
        }
        System.out.println(buycar);
    }
}

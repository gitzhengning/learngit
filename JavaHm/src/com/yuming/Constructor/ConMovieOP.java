package com.yuming.Constructor;

public class ConMovieOP {
    private ConMovie[] movies;

    public ConMovieOP(ConMovie[] movies) {
        this.movies = movies;
    }

    //展示全部电影信息
    public void printall() {
        System.out.println("全部电影信息如下：");
        for (int i = 0; i < movies.length; i++) {
            ConMovie m = movies[i];
            System.out.println("电影编号：" + m.getId());
            System.out.println("电影名称：" + m.getName());
            System.out.println("价格：" + m.getPrice());
        }
    }

    //按编号查询电影信息
    public void printid(int id){
            for (int i = 0; i < movies.length; i++) {
                ConMovie m = movies[i];
                if(m.getId() == id){
                    System.out.println("查询电影信息如下：");
                    System.out.println("电影编号：" + m.getId());
                    System.out.println("电影名称：" + m.getName());
                    System.out.println("价格：" + m.getPrice());
                    System.out.println("演员：" + m.getActor());
                }else{
                    System.out.println("无此电影详细信息。");
                }
            }
    }

}

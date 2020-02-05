package com.tc.beanregister;

/**
 * @Auther: tianchao
 * @Date: 2020/2/4 16:44
 * @Description:
 */
public class Monkey {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    private TaoZi taoZi;
    private XiangJiao xiangJiao;

    public Monkey(TaoZi taoZi, XiangJiao xiangJiao) {
        System.out.println("Monkey(TaoZi taoZi, XiangJiao xiangJiao)"+taoZi+"========"+xiangJiao);
        this.taoZi = taoZi;
        this.xiangJiao = xiangJiao;
    }

    @Override
    public String toString() {
        return "Monkey{" +
                "name='" + name + '\'' +
                '}';
    }
}

package com.tc.bean;

import ioc.anno.Autowired;
import ioc.anno.Component;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */
@Component
public class Fox {
    @Autowired
    private Cat cat;

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Fox{" +
                "cat=" + cat +
                '}';
    }
}

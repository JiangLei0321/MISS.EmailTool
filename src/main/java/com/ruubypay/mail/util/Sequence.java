package com.ruubypay.mail.util;

/**
 * 自增序列
 * Created by jianglei on 18/10/30.
 */
public class Sequence {
    private static int index = 0;
    private static final int maxIndex = 9999;

    public synchronized static int getNextIndex(){
        if(index >= maxIndex){
            index = 0;
        }
        return index++;
    }
}

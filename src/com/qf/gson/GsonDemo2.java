package com.qf.gson;

import com.google.gson.Gson;
import com.qf.entity.Score;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象转字符串
 */
public class GsonDemo2 {

    @Test
    public void test1(){
        //1,普通的对象转换成json字符串
        Score score = new Score(34,23);
        Gson gson = new Gson();
        String json = gson.toJson(score);
        System.out.println(json);

    }

    /**
     * 集合转成json字符串
     */
    @Test
    public void test2(){
        List<Score> list = new ArrayList<>();
        Score score1 = new Score(34,65);
        Score score2 = new Score(34,65);
        list.add(score1);
        list.add(score2);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }

}

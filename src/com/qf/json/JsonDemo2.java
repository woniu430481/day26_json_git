package com.qf.json;

import com.qf.entity.Score;
import com.qf.entity.Student;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 将java对象解析成json字符串
 */
public class JsonDemo2 {

    @Test
    public void testDemo1(){
        //1,简单的对象
        Score score = new Score(34,78);
        JSONObject jsonObject = new JSONObject(score);
        System.out.println(jsonObject.toString());

        System.out.println("============");

    }


    @Test
    public void testDemo2(){
        Score score = new Score(34,78);
        //2,复杂的对象
        Student stu = new Student("woow",23,"女",score);
        JSONObject jsonObject = new JSONObject(stu);
        System.out.println(jsonObject.toString());


    }


    @Test
    public void testDemo3(){
        //3,将集合转换成json字符串
        List<Score> list = new ArrayList<>();
        Score score1 = new Score(34,65);
        Score score2 = new Score(34,65);
        list.add(score1);
        list.add(score2);
        JSONArray jsonArray = new JSONArray(list);
        System.out.println(jsonArray.toString());


    }

}

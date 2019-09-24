package com.qf.jsonlib;

import entity.Score;
import entity.Student;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象转成json字符串
 */
public class JsonLibDemo2 {


    /**
     * 将对象解析成json字符串
     */
    @Test
    public void test1(){
        Student stu = new Student();
        stu.setName("张三");
        stu.setAge(23);
        //将对象转成json字符串
        JSONObject jsonObject = new JSONObject(stu);
        System.out.println(jsonObject.toString());

    }

    /**
     * 对象里面嵌套了对象转json字符串
     */
    @Test
    public void testDemo2(){
        Score score = new Score(34,78);
        //2,复杂的对象
        Student stu = new Student("woow",23,score);
        JSONObject jsonObject = new JSONObject(stu);
        System.out.println(jsonObject.toString());


    }


    /**
     * 集合转json字符串
     */
    @Test
    public void testDemo3(){
        //3,将集合转换成json字符串
        List<Score> list = new ArrayList<>();
        Score score1 = new Score(34,65);
        Score score2 = new Score(34,65);
        list.add(score1);
        list.add(score2);
        //将集合对象放入JSONArray
        JSONArray jsonArray = new JSONArray(list);
        System.out.println(jsonArray.toString());


    }

}

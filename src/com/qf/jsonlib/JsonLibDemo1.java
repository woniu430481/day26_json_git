package com.qf.jsonlib;

import entity.Score;
import entity.Student;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * jsonlib ：解析器,是将json字符串解析成java对象
 */
public class JsonLibDemo1 {


    /**
     * 解析简单形式的json字符串
     */
    @Test
    public void test1() throws JSONException {
        String  json = "{name:'小明',age:12}";

        JSONObject jsonObject = new JSONObject(json);
        String name = jsonObject.getString("name");
        int age = jsonObject.getInt("age");
//        System.out.println("name:"+name);
//        System.out.println("age:"+age);
        //封装成对象
        Student stu = new Student();
        stu.setName(name);
        stu.setAge(age);
        System.out.println(stu);

    }

    /**
     * 复杂形式的json格式字符串，解析成java对象
     * @throws JSONException
     */
    @Test
    public void test2() throws JSONException {
        //对象里面嵌套了对象
        String json = "{name:'小明',age:12,score:{englishScore:23,mathScore:45}}";
        //解析器解析字符串
        JSONObject jsonObject = new JSONObject(json);
        String name = jsonObject.getString("name");
        int age = jsonObject.getInt("age");
        JSONObject obj = jsonObject.getJSONObject("score");
        double englishScore = obj.getDouble("englishScore");
        double mathScore = obj.getDouble("mathScore");

        //封装对象
        Score score = new Score(englishScore,mathScore);

        Student stu = new Student(name,age,score);
        System.out.println(stu);
    }


    /**
     * 数组形式的json字符串
     * @throws JSONException
     */
    @Test
    public void test3() throws JSONException {
        //数组形式的json字符串
        String json = "[{englishScore:23,mathScore:34},{englishScore:45,mathScore:66}]";
        //解析数组形式的json字符串
        JSONArray jsonArray = new JSONArray(json);

        List<Score> list = new ArrayList<>();
        for(int i=0;i<jsonArray.length();i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            double englishScore = jsonObject.getDouble("englishScore");
            double mathScore = jsonObject.getDouble("mathScore");
            //封装对象
            Score score = new Score(englishScore,mathScore);
            list.add(score);
        }


        System.out.println(list);
        

    }



}

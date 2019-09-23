package com.qf.json;

import com.qf.entity.Score;
import com.qf.entity.Student;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;


/**
 * Jsonlib：解析器
 */

public class JsonDemo1 {
    /*
    Java：
      Person p = new Person();
      p.setName("张三");
      p.setAge(23);
      p.setGender("男");
    JavaScript：
      var p = {"name":"张三","age":23,"gender":"男"};
     */

    public static void main(String[] args) throws JSONException {



    }

    /**
     * 解析简单的json格式
     * @throws JSONException
     */
    @Test
    public void testDemo1() throws JSONException {

        //前端传递过来一个字符串
        String str = "{\"name\":\"张三\",\"age\":23,\"gender\":\"男\"}";
        //解析成对象
        JSONObject obj = new JSONObject(str);
        String name = obj.getString("name");
        int age = obj.getInt("age");
        String gender = obj.getString("gender");


        System.out.println("name:"+name);
        System.out.println("age:"+age);
        System.out.println("gender:"+gender);

    }


    /**
     * 解析对象里面嵌套对象的json字符串
     * @throws JSONException
     */
    @Test
    public void testDemo2() throws JSONException {

        //json字符串
        String json = "{name:'张三',age:23,gender:'男',score:{englishScore:88,mathScore:66}}";
        //解析成JSON对象
        JSONObject obj = new JSONObject(json);
        String name = obj.getString("name");
        int age = obj.getInt("age");
        String gender = obj.getString("gender");
        JSONObject score = obj.getJSONObject("score");
        double englishScore = score.getDouble("englishScore");
        double mathScore = score.getDouble("mathScore");


        //封装为Score对象
        Score scoreObj = new Score(englishScore,mathScore);
        //封装Student对象
        Student stu = new Student(name,age,gender,scoreObj);
        System.out.println(stu);

    }

    /**
     * 解析数组形式的json格式
     * @throws JSONException
     */
    @Test
    public void testDemo3() throws JSONException {
        String json = "[{englishScore:23,mathScore:34},{englishScore:45,mathScore:66}]";
        //解析成JSONArray对象
        JSONArray jsonArray = new JSONArray(json);
        //定义一个集合
        List<Score> list = new ArrayList<>();
        //遍历JSONArray
        for(int i=0;i<jsonArray.length();i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            double englishScore = jsonObject.getDouble("englishScore");
            double mathScore = jsonObject.getDouble("mathScore");
            Score score = new Score(englishScore,mathScore);
            list.add(score);
        }

        System.out.println(list);


    }

    public void test(){

    }





}

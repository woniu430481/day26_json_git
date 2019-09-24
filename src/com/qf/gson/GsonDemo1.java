package com.qf.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entity.Score;
import entity.Student;
import org.json.JSONException;
import org.junit.Test;

import java.util.ArrayList;

/**
 * 谷歌公司提供的json解析器
 */
public class GsonDemo1 {


    /**
     * 简单形式的字符串转对象
     */
    @Test
    public void test1(){

        String  json = "{name:'小明',age:12}";
        Gson gson = new Gson();
        //谷歌公司的解析器，通过字节码的反射机制，可以完成的字符串转对象的事情，
        Student student = gson.fromJson(json, Student.class);

        System.out.println(student);

    }

    /**
     * 复杂形式的json格式字符串，解析成java对象
     */
    @Test
    public void test2(){
        //对象里面嵌套了对象
        String json = "{name:'小明',age:12,score:{englishScore:23,mathScore:45}}";
        Gson gson = new Gson();
        Student student = gson.fromJson(json, Student.class);
        System.out.println(student);
    }

    /**
     * 数组形式的json字符串
     */
    @Test
    public void test3() {
        //数组形式的json字符串
        String json = "[{englishScore:23,mathScore:34},{englishScore:45,mathScore:66}]";

        Gson gson = new Gson();
//        ArrayList arrayList = gson.fromJson(json, ArrayList.class);
//        for(Object obj:arrayList){
//            System.out.println(obj);
//        }
        /*
        抛异常
        java.lang.ClassCastException: com.google.gson.internal.StringMap cannot be cast to entity.Score
         */
//        ArrayList<Score> arrayList = gson.fromJson(json, ArrayList.class);
//        for(Score score:arrayList){
//            System.out.println(score);
//        }

        //解析成有具体的类型的集合
        //实例化TypeToken,TypeToken的泛型为fromJson返回的对象类型
        //构造方法的访问修饰符为protected,需要new 类名<泛型>(){}
        //这里的空参构造方法权限修饰符是protected,那木只有其子类可访问，预示着要使用子类构造。
        //new TypeToken<List<Score>>(){}是一个匿名内部类，其等价MyTypeToken<List<Score>> extends TypeToken(){}

        TypeToken<ArrayList<Score>> typeToken = new TypeToken<ArrayList<Score>>(){};

        ArrayList<Score> list = gson.fromJson(json, typeToken.getType());
        for(Score score:list){
            System.out.println(score);
        }

    }

}

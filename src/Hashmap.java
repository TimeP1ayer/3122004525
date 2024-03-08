import java.util.Scanner;
import java.util.HashMap;

public class Hashmap {
    public static HashMap hashmap(String str){

        //将字符串转换成字符数组
        char[] arr = str.toCharArray();
        //定义双列集合，存储字符串字符以及字符出现的次数
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();

        for(char c:arr){
            //如果集合中不包含这个键，就将该字符当作键，值为1存储，如果集合中包含这个键，就将值增加1存储
            if(!hm.containsKey(c))
                hm.put(c, 1);
            else
                hm.put(c,hm.get(c)+1);
        }



        if (true) {
            for (Character key : hm.keySet())     //hm.keySet()代表所有键的集合
                System.out.println(key + "=" + hm.get(key));    //hm.get(key)根据键获取值
        }

        return hm;
    }


}

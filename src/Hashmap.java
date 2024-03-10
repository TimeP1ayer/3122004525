import java.util.HashMap;
import java.util.TreeMap;

public class Hashmap {
    public static TreeMap treemap(String str){

        //将字符串转换成字符数组
        char[] arr = str.toCharArray();
        //定义双列集合，存储字符串字符以及字符出现的次数
        TreeMap<Character,Integer> tm = new TreeMap<>();

        for(char c:arr){
            //如果集合中不包含这个键，就将该字符当作键，值为1存储，如果集合中包含这个键，就将值增加1存储
            if(!tm.containsKey(c))
                tm.put(c, 1);
            else
                tm.put(c,tm.get(c)+1);
        }


        //输出哈希表
        if (false) {
            for (Character key : tm.keySet())     //tm.keySet()代表所有键的集合
                System.out.println(key + "=" + tm.get(key));    //tm.get(key)根据键获取值
        }

        return tm;
    }


}

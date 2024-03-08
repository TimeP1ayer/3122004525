/*
获取两个哈希表
原文哈希表为向量A
抄袭版论文为向量B
进行向量相似比较
HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class compare {
    public static float textcompare(HashMap A,HashMap B){

        float result;
        float multi = 0;

        //A,B模长

        float Asq = 0,Bsq=0;

        //AB迭代器
        Iterator<Map.Entry<Character,Integer>> iteratorA = A.entrySet().iterator();
        Iterator<Map.Entry<Character,Integer>> iteratorB = B.entrySet().iterator();



        //迭代计算A的模长
        while (iteratorA.hasNext()){

            Map.Entry<Character,Integer>entryA = iteratorA.next();
            Asq += Math.pow(entryA.getValue(),2);

        }

        //迭代计算B的模长

        while (iteratorB.hasNext()){
            Map.Entry<Character,Integer>entryB = iteratorB.next();
            Bsq += Math.pow(entryB.getValue(),2);
        }


        /*
        计算AB向量乘积
        B向量比A短，所以B后面的相乘均为0，B的值没有之后则结束计算
         */

        //二次迭代
        Iterator<Map.Entry<Character,Integer>> iteratorA1 = A.entrySet().iterator();
        Iterator<Map.Entry<Character,Integer>> iteratorB1 = B.entrySet().iterator();
        while (iteratorB1.hasNext()){
                Map.Entry<Character,Integer>entryB = iteratorB1.next();
                Map.Entry<Character,Integer>entryA = iteratorA1.next();



            if(entryB.getKey()==entryA.getKey()){
                multi += entryB.getValue()*entryA.getValue();
            } else{

            }


        }

        result = multi/Asq*Bsq;


        //未完成返回两位小数
        return result;
    }
}


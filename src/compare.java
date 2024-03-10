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
import java.util.Scanner;


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

        System.out.println("Asq为："+Asq);
        System.out.println("Bsq为："+Bsq);

        /*
        计算AB向量乘积
        B向量比A短，所以B后面的相乘均为0，B的值没有之后则结束计算
         */

        //二次迭代
        Iterator<Map.Entry<Character,Integer>> iteratorA1 = A.entrySet().iterator();
        Iterator<Map.Entry<Character,Integer>> iteratorB1 = B.entrySet().iterator();

        //跳过哈希表头节点
        Map.Entry<Character,Integer>entryB1;
        Map.Entry<Character,Integer>entryA1;

        if(iteratorB1.hasNext()){
            if(iteratorA1.hasNext()){
                //初始化迭代器
                entryB1 = iteratorB1.next();
                entryA1 = iteratorA1.next();
                if(entryA1.getKey().toString().equals(entryB1.getKey().toString())){
                    multi+=entryB1.getValue()*entryA1.getValue();
                }

                if(false){
                    Scanner scanner = new Scanner(System.in);
                    String s =scanner.nextLine();
                }


                while (true){
                    if(entryA1.getKey().toString().equals(entryB1.getKey().toString())){
                        System.out.println("A等于B");
                        if(iteratorB1.hasNext()){
                            //计算乘积，AB移动到下一个位置
                            if(iteratorA1.hasNext()) {
                                entryB1 = iteratorB1.next();
                                entryA1 = iteratorA1.next();

                                int m = entryB1.getValue();
                                int n = entryA1.getValue();

                                System.out.println("m:"+m+" "+entryB1.getKey());
                                System.out.println("n:"+n+" "+entryA1.getKey());
                                multi += m*n;
                                System.out.println("multi:"+multi);
                            }

                        }else{
                            //B向量结束，结束循环
                            System.out.println("结束");
                            break;
                        }
                    }else{
                        //对于键，A不等于B，A移动到下一个位置
                        System.out.println("A不等于B");
                        System.out.println("itA1:"+iteratorA1.hasNext());
                        System.out.println("A:"+entryA1.getValue()+" "+entryA1.getKey());
                        System.out.println("B:"+entryB1.getValue()+" "+entryB1.getKey());
                        System.out.println("******************");

                        if(iteratorA1.hasNext()) {
                            entryA1= iteratorA1.next();
                            int k = entryA1.getValue();
                            System.out.println("k:"+k);
                        }else {break;}
                    }
                }

            }

        }

        result = (float) (multi/Math.sqrt(Asq*Bsq));
        System.out.println("重复率为："+result);
        return result;
    }
}


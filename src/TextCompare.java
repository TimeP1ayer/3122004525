import java.util.*;
/**
 * @author QWattson
 *
 * @date 2024/3/12 0:00
 *
 * 获取两个哈希表
 * 原文哈希表为向量A
 * 抄袭版论文为向量B
 * 进行向量相似比较
 *
 */

public class TextCompare {

    /**
     *
     * @param origin 原文
     * @param copy 抄袭文章
     * @return 向量模长
     */

    public static float modulusCount(TreeMap origin, TreeMap copy){

        //origin,B模长
        float modulusA = 0,modulusB=0;

        //AB迭代器
        Iterator<Map.Entry<Character,Integer>> iteratorA = origin.entrySet().iterator();
        Iterator<Map.Entry<Character,Integer>> iteratorB = copy.entrySet().iterator();

        //迭代计算A的模长
        while (iteratorA.hasNext()){
            Map.Entry<Character,Integer>entryA = iteratorA.next();
            modulusA += Math.pow(entryA.getValue(),2);
        }


        //迭代计算B的模长
        while (iteratorB.hasNext()){
            Map.Entry<Character,Integer>entryB = iteratorB.next();
            modulusB += Math.pow(entryB.getValue(),2);
        }

        System.out.println("Asq为："+modulusA);
        System.out.println("Bsq为："+modulusB);

        return modulusA*modulusB;
    }


    /**
     *
     * 计算AB向量乘积
     * B向量比A短，所以B后面的相乘均为0，B的值没有之后则结束计算
     *
    */

    public static float multiplyCount(TreeMap origin, TreeMap copy){

        float multi = 0;

        Iterator<Map.Entry<Character,Integer>> iteratorA1 = origin.entrySet().iterator();
        Iterator<Map.Entry<Character,Integer>> iteratorB1 = copy.entrySet().iterator();

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

                while (true){
                    int m = entryB1.getValue();
                    int n = entryA1.getValue();

                    //System.out.println(entryA1.getKey()+":"+entryA1.getValue());
                    //System.out.println(entryB1.getKey()+":"+entryB1.getValue());

                    if(entryA1.getKey().toString().equals(entryB1.getKey().toString())){
                        if(iteratorB1.hasNext()){
                            //计算乘积，AB移动到下一个位置
                            if(iteratorA1.hasNext()) {

                                //System.out.println("m*n:"+m*n);

                                multi += m*n;
                                entryB1 = iteratorB1.next();
                                entryA1 = iteratorA1.next();
                            }
                        }else{
                            //B向量结束，结束循环
                            if(entryA1.getKey().toString().equals(entryB1.getKey().toString())){
                                multi += m*n;

                                break;
                            }
                        }
                    }else{
                        //对于键，A不等于B，A移动到下一个位置
                        if(iteratorA1.hasNext()) {
                            entryA1= iteratorA1.next();
                        }else {
                            break;
                        }
                    }
                }
            }
        }
        System.out.println("multi:"+multi);
        System.out.println("算法结束");
        return multi;
    }

    /*总计
    当抄袭文本的某些字重复次数高于原文后有可能出现重复率高于100%的结果
    同时也会出现重复率过小的问题，原因是向量的模相乘的时候太大了
    */

    public static float totalCount(TreeMap origin, TreeMap copy){

        float aMultipyb = modulusCount(origin,copy);
        float multi = multiplyCount(origin,copy);

        float result;

        result = (float) (multi/Math.sqrt(aMultipyb));

        System.out.println("origin result:"+result);

        if(result>1){
            result = 1.00f;
        }

        return result;
    }
}


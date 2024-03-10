import java.util.TreeMap;

/*
测试路径
D:
cd D:\SEwork\Text plagiarism check\out\artifacts\TextPlagiarismCheck_jar
java -jar TextPlagiarismCheck.jar "D:\\Users\\Desktop\\orig.txt" "D:\\Users\\Desktop\\copy.txt" "D:\\Users\\Desktop\\result.txt"
 */
public class Main {
    public static void main(String[] args) {

        String originpath = null;
        String copypath = null;
        String outputpath = null;

        if(args.length!=0) {
            originpath = args[0];
            copypath = args[1];
            outputpath = args[2];
        }

        System.out.println();
        System.out.println("指令1：" + originpath);
        System.out.println("指令2：" + copypath);
        System.out.println("指令3：" + outputpath);

        //原版论文
        String str1 = readtext.readtxt("D:\\Users\\Desktop\\orig.txt");

        //抄袭版论文
        String str2 = readtext.readtxt("D:\\Users\\Desktop\\orig_0.8_del.txt");

        //重复率
        float result = 0;
        TreeMap<Character, Integer> A = null;
        TreeMap<Character,Integer> B = null;


        if (str1 != null & str2 != null) {
            A = Hashmap.treemap(str1);
            B = Hashmap.treemap(str2);
        }



        if(A!=null&&B!=null)
        result = compare.textcompare(A,B);

        String finalresult = String.format("%.2f",result);

        //写入比较数据
        writetext.writetxt("D:\\Users\\Desktop\\result.txt",finalresult);

    }
}

import java.util.HashMap;

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
        String str1 = readtext.readtxt("D:\\Users\\Desktop\\A.txt");

        //抄袭版论文
        String str2 = readtext.readtxt("D:\\Users\\Desktop\\B.txt");



        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");

        Hashmap.hashmap(str2);

        //重复率
        float result;

        HashMap<Character,Integer> A ;
        HashMap<Character,Integer> B ;

        A = Hashmap.hashmap(str1);
        B = Hashmap.hashmap(str2);

        result = compare.textcompare(A,B);

        String finalresult = String.format("%.2f",result);

        //写入比较数据
        writetext.writetxt("D:\\Users\\Desktop\\result.txt",finalresult);

    }
}

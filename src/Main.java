import java.text.DecimalFormat;
import java.util.TreeMap;

/**
 * @author QWattson
 */

/*
测试路径
D:
cd D:\SEwork\Text plagiarism check\out\artifacts\TextPlagiarismCheck_jar
java -jar TextPlagiarismCheck.jar "D:\\Users\\Desktop\\orig.txt" "D:\\Users\\Desktop\\orig_0.8_del.txt" "D:\\Users\\Desktop\\result.txt"
 */
public class Main {
    public static void main(String[] args) {

        //测试路径
        String originPath = "D:\\Users\\Desktop\\orig.txt";
        String copyPath = "D:\\Users\\Desktop\\orig_0.8_del.txt";
        String outputPath = "D:\\Users\\Desktop\\result.txt";

        if(args.length!=0) {
            originPath = args[0];
            copyPath = args[1];
            outputPath = args[2];
        }

        System.out.println();
        System.out.println("指令1：" + originPath);
        System.out.println("指令2：" + copyPath);
        System.out.println("指令3：" + outputPath);
        System.out.println();

        /*原版论文   originPath
          抄袭论文   copyPath
         */
        String str1 = ReadText.readTxt(originPath);
        String str2 = ReadText.readTxt(copyPath);

        if(str1==null||str2==null){
            System.out.println("wrong filepath");
            System.out.println("program exit");
            return;
        }

        //重复率
        float result;
        TreeMap<Character, Integer> originMap = Hashmap.treemap(str1);
        TreeMap<Character,Integer> copyMap = Hashmap.treemap(str2);


        result = TextCompare.totalCount(originMap,copyMap);

        // TODO: 2024/3/12  
        //数位待处理
        DecimalFormat decimalFormat = new DecimalFormat(".00");


        System.out.println("result:"+result);

        //转换为两位数字
        String final_result = String.valueOf(result).substring(0,4);
        System.out.println("final:"+final_result);


        WriteText.writeTxt("D:\\Users\\Desktop\\result.txt", String.valueOf(result));

    }
}
/*
测试路径
D:
cd D:\SEwork\Text plagiarism check\out\artifacts\TextPlagiarismCheck_jar
java -jar TextPlagiarismCheck.jar "D:\\Users\\Desktop\\orig.txt" "D:\\Users\\Desktop\\orig_0.8_del.txt" "D:\\Users\\Desktop\\result.txt"
java -jar TextPlagiarismCheck.jar "D:\\Users\\Desktop\\A.txt" "D:\\Users\\Desktop\\B.txt" "D:\\Users\\Desktop\\result.txt"
 */
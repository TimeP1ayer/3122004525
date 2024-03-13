import java.text.DecimalFormat;
import java.util.TreeMap;

/**
 * @author QWattson
 */

/**终端测试路径
 * D:
 * cd D:\SEwork\Text plagiarism check\out\artifacts\TextPlagiarismCheck_jar
 * java -jar TextPlagiarismCheck.jar "D:\\Users\\Desktop\\orig.txt" "D:\\Users\\Desktop\\orig_0.8_del.txt" "D:\\Users\\Desktop\\result.txt"
 * java -jar TextPlagiarismCheck.jar "D:\\Users\\Desktop\\orig.txt" "D:\\Users\\Desktop\\orig.txt" "D:\\Users\\Desktop\\result.txt"
 *
 */
public class Main {
    public static void main(String[] args) {

        //测试路径
        String originPath = "D:\\Users\\Desktop\\orig.txt";

        String copyPath = "D:\\Users\\Desktop\\orig_0.8_del.txt";
        /**其他抄袭文章测试路径
         * "D:\\Users\\Desktop\\orig_0.8_dis_1.txt"
         * "D:\\Users\\Desktop\\orig_0.8_dis_10.txt"
         * "D:\\Users\\Desktop\\orig_0.8_dis_15.txt"
         * "D:\\Users\\Desktop\\orig_0.8_del.txt"
         * "D:\\Users\\Desktop\\orig_0.8_add.txt"
         *
         */
        String outputPath = "D:\\Users\\Desktop\\result.txt";

        //接受终端指令
        if(args.length==3) {
            originPath = args[0];
            copyPath = args[1];
            outputPath = args[2];
            System.out.println("指令来自终端：");
        }else {
            System.out.println("指令来自本地：");
        }

        System.out.println("指令1：" + originPath);
        System.out.println("指令2：" + copyPath);
        System.out.println("指令3：" + outputPath);
        System.out.println("--------------");

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
        TreeMap<Character, Integer> originMap = Treemap.treemap(str1);
        TreeMap<Character,Integer> copyMap = Treemap.treemap(str2);


        result = TextCompare.totalCount(originMap,copyMap);

        //数位处理
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");

        System.out.println("result:"+result);

        //转换为两位小数
        String finalResult = decimalFormat.format(result);
        System.out.println("print out result:"+finalResult);
        WriteText.writeTxt("D:\\Users\\Desktop\\result.txt", finalResult);

    }
}

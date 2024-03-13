import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author QWattson
 *
 * 输入文本路径返回文本string
 * filepath 文本路径
 */

public class ReadText {
    public static String readTxt(String filepath){
        File file = new File(filepath);

        System.out.print("filepath:"+filepath);
        System.out.println("   check:"+file.exists());
        System.out.println("--------------");
        //文件不存在
        if(!file.exists()){
            System.out.println("file does not exist!");
            return null;
        }

        if(file.isFile()&&file.exists()){
            try {
                //创建输入流,使用UTF-8格式读取
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuffer stringBuffer = new StringBuffer();
                String text ;

                //读取文件每一行文字
                while((text = bufferedReader.readLine())!=null){
                    //去除空格去除标点
                    text = text.replaceAll("[\\s*|\\t\\r\\n\\pP\\p{Punct}]", "");
                    //添加到文本
                    stringBuffer.append(text);
                }
                return  stringBuffer.toString();

            }catch (Exception e){
                //异常处理
                System.out.println("readtext wrong");
                return null;
            }
        }
        return null;
    }
}

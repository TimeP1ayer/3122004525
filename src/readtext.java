import java.io.*;
/*
输入文本路径返回文本string
filepath 文本路径

 */
public class readtext {
    public static String readtxt(String filepath){
        File file = new File(filepath);
        if(file.isFile()&&file.exists()){
            try {
                //创建输入流
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuffer sb = new StringBuffer();
                String text ;

                //读取文件每一行文字
                while((text = bufferedReader.readLine())!=null){
                    //去除空格去除标点
                    text = text.replaceAll("[\\s*|\\t\\r\\n\\pP\\p{Punct}]", "");
                    //添加到文本
                    sb.append(text);
                }
                return  sb.toString();

            }catch (Exception e){
                //异常处理
                e.printStackTrace();
            }
        }
        return null;
    }
}

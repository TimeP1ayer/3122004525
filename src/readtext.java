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
                    //去除标点符号
                    //添加到文本
                    sb.append(text.replaceAll("[\\pP\\p{Punct}]", ""));
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

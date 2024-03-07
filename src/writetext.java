/*写入文本
filepath 文本存放路径
text文本内容

 */

import java.io.File;
import java.io.FileOutputStream;

public class writetext {
    public static void writetxt(String filepath,String text){

        //创建输出流
        FileOutputStream fileOutputStream = null;
        File file = new File(filepath);

        try {
            if(file.exists()){
                //判断文件是否存在，如果不存在就新建一个txt
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            //写入文本
            fileOutputStream.write(text.getBytes());

            //写入关闭
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author QWattson
 * 写入文本
 * filepath 文本存放路径
 * text 文本内容
 */
public class WriteText {
    public static void writeTxt(String filepath, String text){

        //创建输出流
        FileOutputStream fileOutputStream;
        File file = new File(filepath);

        try {

            if (!file.exists()) {
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

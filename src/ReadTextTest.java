import org.junit.Test;

public class ReadTextTest {

    @Test
    //空文件测试
    public void test1(){
        System.out.println("空文件测试");
        ReadText.readTxt("D:\\Users\\Desktop\\empty.txt");
        System.out.println();
}

    @Test
    //错误路径测试,即不存在此文件
    public void test2(){
        System.out.println("错误路径测试");
        ReadText.readTxt("D:\\Users\\Desktop\\null.txt");
        System.out.println();
    }

    @Test
    //正确路径测试
    public void test3(){
        System.out.println("正确路径测试");
        ReadText.readTxt("D:\\Users\\Desktop\\orig.txt");
        System.out.println();
    }
}
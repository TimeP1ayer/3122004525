import org.junit.Test;

public class WriteTextTest {

    @Test
    //空文件测试
    public void test1(){
        System.out.println("空文本测试");
        WriteText.writeTxt("D:\\Users\\Desktop\\result.txt","");
        System.out.println();
    }

    @Test
    //错误路径测试,即不存在此文件
    public void test2(){
        System.out.println("错误路径测试");
        WriteText.writeTxt("D:\\Users\\Desktop\\null.txt","错误路径测试");
        System.out.println();
    }

    @Test
    //空路径测试
    public void test3(){
        System.out.println("空路径测试");
        WriteText.writeTxt("","空路径测试");
        System.out.println();
    }

    @Test
    //正确路径文本测试
    public void test4(){
        System.out.println("正确路径文本测试");
        WriteText.writeTxt("D:\\Users\\Desktop\\result.txt","正确测试");
        System.out.println();
    }

}
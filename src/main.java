public class main {
    public static void main(String[] args) {
        String str = readtext.readtxt("D:\\Users\\Desktop\\orig.txt");
        writetext.writetxt("D:\\Users\\Desktop\\copy.txt",str);
        System.out.println(str);
    }
}

public class main {
    public static void main(String[] args) {

//        String originpath = args[0];
//        String copypath = args[1];
//        String outputpath = args[2];

        String str = readtext.readtxt("D:\\Users\\Desktop\\orig.txt");
        writetext.writetxt("D:\\Users\\Desktop\\copy.txt",str);
        System.out.println(str);
    }
}

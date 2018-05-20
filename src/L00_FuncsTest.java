import java.io.File;

public class L00_FuncsTest {

    static Integer iinntt = 11;
    final static Integer iinntttt = 11;

    public static class MyData {

        public static Integer myInteger0 = 0;
        public static Integer myInteger1;
        public static String patchToLogFiles;
        public static File folder = new File(patchToLogFiles);
        public static File[] listOfFiles = folder.listFiles();

    }

    public static void main(String[] args) {

        testFunc1(MyData.myInteger0);

        testFunc2(2);

        testFunc3(3);

    }


    public static Boolean testFunc1 (int i1) {

        MyData.myInteger0 = 5;
//        MyData.listOfFiles;

        return true;

    }

    public static Boolean testFunc2 (int i2) {

        Integer myInteger3 = iinntttt;

        return true;

    }

    public static Boolean testFunc3 (int i3) {

        iinntt = 55;


        return true;

    }

}

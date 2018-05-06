public class L103_AddTwoNumbersClass {


    public static void main(String[] args) {

        System.out.println(addNum(3, 3));

    }


    public static int addNum(int num1, int num2) {

        //return num1+num2;
        return num1-~num2-1;

    }
}

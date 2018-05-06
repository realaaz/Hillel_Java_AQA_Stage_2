import  java.util.*;

public class L101_TheGame {



    public static void main(String[] args) {

        System.out.println("enter number from 0 to 9");
        Scanner inNum = new Scanner(System.in);

        // TODO: 5/4/18 : filter not integer input values

        int inNum2 = inNum.nextInt();
        System.out.println(inNum2);


        int random2 = 0 + (int) (Math.random() * 9);

        System.out.println("random2 "+random2);

            if(inNum2 > random2)
            {
                System.out.println(inNum2+" is a bigger number");
            }
            else if(inNum2 < random2)
            {
                System.out.println(inNum2+" is a less number");
            }
//            else if (inNum2 != random2)
//            {
//                System.out.println(inNum2+" is not equal");
//            }
            else if (inNum2 == random2)
            {
                System.out.println(inNum2+"You Win!");
            }
            else
            {
                System.out.println("invalid input data");
            }




    }






}

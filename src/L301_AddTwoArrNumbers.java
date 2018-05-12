import java.util.HashMap;
import java.util.Map;

public class L301_AddTwoArrNumbers {

    public static void main(String[] args) {

        int[] someArr = {1,2,3};

        AddTwoNum(someArr, 6);

    }

    public static boolean AddTwoNum(int[] inArray, int inNum) {

        Map<String, Integer> newArray = new HashMap<>();

        int sum, i, a;

        for (i = 0; i < inArray.length; i++) {
            for (a = i+1; a < inArray.length; a++) {

                if (inArray[i]+ inArray[a] == inNum) {
                    System.out.println("true");
                    return true;

                }
            }
        }
        System.out.println("false");
        return false;
    }



}

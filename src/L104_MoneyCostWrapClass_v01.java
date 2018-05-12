public class L104_MoneyCostWrapClass_v01 {

    public static void main(String[] args) {

        System.out.println("chocolate were bought: " + ManyCostWrapClass(100, 10, 2));

    }

//    money cost wrap -> func which returns count of chocolates that we can buy
//    0) total amount paid:          money
//    1) cost of one piece of choco: cost
//    2) exchange rate of packages:  wrap

    public static int ManyCostWrapClass (int money, int cost, int wrapExRate) {

        // money processing
        int countChFirst = money / cost;


        // wrappers processing
        int countChFinal = countChFirst;

        while (countChFirst >= (wrapExRate)) {

            countChFirst = countChFirst / wrapExRate;
            countChFinal += countChFirst;// + 1;

        }

        return  countChFinal;

    }

}
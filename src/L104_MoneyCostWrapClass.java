public class L104_MoneyCostWrapClass {

    public static void main(String[] args) {

        System.out.println("chocolate were bought: " + ManyCostWrapClass(100, 10, 1));

    }

//    money cost wrap -> func which returns count of chocolates that we can buy
//
//    0) total amount paid:          money
//    1) cost of one piece of choco: cost
//    2) exchange rate of packages:  wrap
//
//    Robert's desicion
//    mpw
//    c=m/p
//    return c+(c-1)/(w-1)

    public static int ManyCostWrapClass (int money, int cost, int wrapExRate) {

        // money processing
        int countChFirst = money / cost;

        // wrappers processing
        int countChFinal = countChFirst;

        while (countChFirst >= (wrapExRate)) {

            countChFirst = countChFirst - wrapExRate;
            countChFinal = countChFinal + 1;

        }

        return  countChFinal;

    }

}
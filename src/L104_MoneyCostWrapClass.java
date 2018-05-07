public class L104_MoneyCostWrapClass {

    public static void main(String[] args) {

        ManyCostWrapClass(80, 10, 2);

    }

    // money cost wrap -> func which returns count of chocolates that we can buy

    // 0) total amount paid:          money
    // 1) cost of one piece of choco: cost
    // 2) exchange rate of packages:  wrap

    public static int ManyCostWrapClass (int money, int cost, int wrapExRate) {

        // money processing
        int countChFirst = money/cost;

        // wrappers processing
        int countChFinal = countChFirst;

        while (countChFirst >= (wrapExRate)) {

            countChFirst = countChFirst-wrapExRate;
            countChFinal = countChFinal + 1;

        }

        System.out.println("денег было при входе в магаз: " + money);
        System.out.println("стоимость каждой шоколадки: " + cost);
        System.out.println("всего шоколадок в итоге: " + countChFinal);

        return  countChFinal;

    }

}
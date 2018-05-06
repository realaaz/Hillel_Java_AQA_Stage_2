public class L104_MoneyCostWrapClass {

    public static void main(String[] args) {

        ManyCostWrapClass(100, 11, 3);

    }

    // money cost wrap -> func which returns
    // 1) 1 шоколадка X доллар
    // 2) можно купить 1 шоколадку за Y оберок

    public static int ManyCostWrapClass (int money, int cost, int wrap) {

        // money processing
        int countCh1 = money/cost;

        // wrappers processing
        int countCh2 = countCh1/wrap;

        // total chocolates processing
        int countCh3 = countCh1 + countCh2;

        System.out.println("денег было при входе в магаз: " + money);
        System.out.println("стоимость каждой шоколадки: " + cost);
        System.out.println("купили такое количество шоколадок и получили упаковок: " + countCh1);
        System.out.println("получили шоколадки за упаковки: " + countCh2);
        System.out.println("всего шоколадок в итоге: " + countCh3);

        return  countCh2;

    }

}
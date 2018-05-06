public class L104_MoneyCostWrapClass {

    public static void main(String[] args) {

        ManyCostWrapClass(100, 11, 3);


    }

    // money cost wrap
    // 1 шоколадка 1 доллар
    // можно купить 1 шоколадку за X оберок

    public static int ManyCostWrapClass (int money, int cost, int wrap) {

        int countCh1 = 0;
        int countCh2 = 0;

        // money processing
        countCh1 = money/cost;

        // wrappers processing
        countCh2 = countCh1/wrap;

        System.out.println("денег было при входе в магаз: " + money);
        System.out.println("каждая шоколадка стоит: " + cost);
        System.out.println("купили такое количество шоколадок и получили упаковки: " + countCh1);
        System.out.println("получили шеколадки за упаковки: " + countCh2);


        return  countCh2;

    }

}
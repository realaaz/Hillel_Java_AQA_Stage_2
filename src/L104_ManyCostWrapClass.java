public class L104_ManyCostWrapClass {

    public static void main(String[] args) {

        ManyCostWrapClass(100, 11, 3);


    }

    // many cost wrap
    // 1 шоколадка 1 доллар
    // можно купить 1 шоколадку за X оберок

    public static int ManyCostWrapClass (int money, int cost, int wrap) {

        int countCh1 = 0;
        int countCh2 = 0;

        // money processing
        countCh1 = money/cost;

        // wrapper processing
        countCh2 = countCh1/wrap;

        System.out.println(countCh1 + " " + countCh2);

        return  countCh2;

    }

}

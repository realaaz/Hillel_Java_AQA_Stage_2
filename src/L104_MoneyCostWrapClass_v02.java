public class L104_MoneyCostWrapClass_v02 {

    public static void main(String[] args) {

        System.out.println("chocolate were bought: " + ManyCostWrapClass(100, 10, 2));

    }

//    Robert's decision
//    mpw
//    c=m/p
//    return c+(c-1)/(w-1)

    public static int ManyCostWrapClass (int m, int p, int w) {

        int countChFirst = m / p;

        return  countChFirst+(countChFirst-1)/(w-1);

    }

}
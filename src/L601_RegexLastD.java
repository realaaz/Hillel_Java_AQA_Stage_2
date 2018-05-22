public class L601_RegexLastD {

    public static void main(String[] args) {

        String someText = " aaaaad " + " bbbd " +  "\n" + " ccdee ";
        String someText2;

        someText2 =  someText.replaceAll("(/g)(.*)d", "$1");

        System.out.println(someText2);


    }
}

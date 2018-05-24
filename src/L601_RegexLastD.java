public class L601_RegexLastD {

    public static void main(String[] args) {

        String someText = " aaaaad " + " bbbd " +  "\n" + " ccDee ";
        String someText2;

        someText2 =  someText.replaceAll("((?:.|\\s)*)[dD]", "$1");

        System.out.println(someText2);


    }
}

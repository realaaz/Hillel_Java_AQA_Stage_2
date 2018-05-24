public class L701_RegexDigitsOnly {


    public static void main(String[] args) {

        String someString = "'Amount: 1599.05'";

        digitsChecker(someString);

    }

    // надо написать регекс, который совпадает только с инпутом вида '1235' (без кавычек),
    // только если число находится в промежутке 0-1600

    // При этом перед числом может быть написано 'Amount: ',
    // а после числа может быть количество копеек вида '.05'

    // http://gamon.webfactional.com/regexnumericrangegenerator/

    public static void digitsChecker(String inString) {

        String outDigits = inString.replaceAll("(?:.*)"+ "\\b([0-9]|[1-8][0-9]|9[0-9]|[1-8][0-9]{2}|9[0-8][0-9]|99[0-9]|1[0-5][0-9]{2}|1600)\\b"+"(?:\\.)(?:.*)", "$1");
        System.out.println(outDigits);

    }


}

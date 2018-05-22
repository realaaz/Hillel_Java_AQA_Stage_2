public class L602_RegexGoogleMail {

    static String someGMailString = "emal1@gmail.com, emal2@gmail.com, emal3@gmail.com";
    static String someNoGMailString = "emal4@gmail.com, emal5@mail.ru, emal6@gmail.com";

    public static void main(String[] args) {

        System.out.println(checkGMail(someGMailString, "@gmail.com"));
        System.out.println(checkGMail(someNoGMailString, "@gmail.com"));

    }

    public static boolean checkGMail(String mailLine, String mailToCheck) {
        String domainsRegex = "(?:.+)" + mailToCheck;

        String[] strings = mailLine.split(",");

        for (String word : strings) {

            if (word.matches(mailToCheck)) {
                return true;
            }
        }
        return false;
    }


}

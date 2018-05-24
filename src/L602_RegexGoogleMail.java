import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class L602_RegexGoogleMail {


    static String someGMailString_Y = "emal1@gmail.com, emal2@gmail.com, emal3@gmail.com";
    static String somoGMailString_N = "emal4@gmail.com, emal5@mail.ru, emal6@gmail.com";


    public static void main(String[] args) {

        System.out.println(checkGMail(someGMailString_Y));
        System.out.println(checkGMail(somoGMailString_N));

    }


    public static boolean checkGMail(String emailsContent) {

        int checkedEmailsCounter = 0;

        Set<String> hashAddress = new HashSet<>(Arrays.asList(emailsContent.replaceAll("[\\s]", "").split(",")));

        Pattern p = Pattern.compile("(.)*@gmail.com");

        for (String checkedEmails : hashAddress) {

            Matcher m = p.matcher(checkedEmails);

            System.out.println(checkedEmails + " : " + m.matches());

            if (m.matches()) {
                checkedEmailsCounter = checkedEmailsCounter + 1;
            }
        }

        System.out.println(checkedEmailsCounter);

        if (checkedEmailsCounter == hashAddress.size()) {
            return true;
        }
        return false;
    }

}

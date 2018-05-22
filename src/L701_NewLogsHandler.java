import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class L701_NewLogsHandler {


    public static void main(String[] args) throws IOException {

        newLogsHandler();

    }


    public static void newLogsHandler() throws IOException {

        String content;

        content = new String(Files.readAllBytes(Paths.get("Logs.txt")));
        System.out.println(content);

        String content1 = content.replaceAll("[.,!?;]", "");
        System.out.println(content1);

        // Output requirements:

        // 01 Jun 3 03:35:46
        // 02 Activity:
        // 03 [Login Username: user1@skyromi.onmicrosoft.com (repository: user1@skyromi.onmicrosoft.com)]
        // 04 [Data Object: Managed User]
        // 05 [Records: forautotestuser1802250406@skyroxsaxicrosoft.com]

        // 06 [User Action: create] [User Action Status: unknown]
        // 07 [Labels: <User Account Settings> ]

        // 08 [Service type: Box]
        // 09 [Mapping Ids: Box-1,Box-2,Box-98]
        // 10 [URI: https://skyromi1.app.box.com/index.php?rm=box_master_users_add_user_via_form]

        String rSS = "(?:.+)";

        String r01 = "(.{15})" + rSS;
        String r02 = "(Activity:)" + rSS;
        String r03 = "(\\[Login Username:(?:.+?)\\])" + rSS;
        String r04 = "(\\[Data Object:(?:.+?)\\])" + rSS;
        String r05 = "(\\[Records:(?:.+?)\\])" + rSS;

        String r06 = "(\\[Labels:(?:.+?)\\])" + rSS;
        String r07 = "(\\[User Action:(?:.+?)\\])" + rSS;

        String r08 = "(\\[Service type:(?:.+?)\\])" + rSS;
        String r09 = "(\\[Mapping Ids:(?:.+?)\\])" + rSS;
        String r10 = "(\\[URI:(?:.+?))";


        String rEx = r01 + r02 + r03 + r04 + r05 + r06 + r07 + r08 + r09 + r10 + "(.+)";

        String content3 = content1.replaceAll(rEx, "$1 $2 $3 $4 $5 $7 $6 $8 $9 $10");

        System.out.println(content3);
        System.out.println(rEx);


    }


}

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.nio.file.Path;
import java.io.IOException;

public class L401_LogsHandler_v02 {

    public static void main(String[] args) throws IOException {

        // 0 get list of log files on the stable patch
        // 1 get count of log files
        logsHandler("Logs");
        // 2 parser log files up to last file
        // 3 regex - needed search string (?)
        // 4 prepare out file (create/close+permissions)
        // 6 println searched lines by log file (1by1)
        // 7 store searched string from logs to out file (bulk)
        // 8 store own logs of handler working??))

    }

    public static int logsHandler (String patchToLogFiles) throws IOException {

        File folder = new File(patchToLogFiles);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File: " + listOfFiles[i].getName());

                String content;
                content = new String(Files.readAllBytes(Paths.get("logs/transactions.log_04-02-18-01:01")));
                System.out.println(content+"\n");
            }

        }
        System.out.println("Number of files: " + listOfFiles.length);
        return listOfFiles.length;
    }





}

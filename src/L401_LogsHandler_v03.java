import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.nio.file.Path;
import java.io.IOException;

public class L401_LogsHandler_v03 {

    public static void main(String[] args) throws IOException {

        // 0 get list of log files on the stable patch
        // 1 get count of log files
        // 2 parser log files up to last file
        // 3 regex - needed search string (?)
        // 4 prepare out file (create/close+permissions)
        // 6 println searched lines by log file (1by1)
        // 7 store searched string from logs to out file (bulk)
        // 8 store own logs of handler working??))

        long startTime = System.currentTimeMillis();

        logsHandler("Logs");

        System.out.println("Execution Time: " + "\t" + (System.currentTimeMillis() - startTime) + " milliseconds");

        long usedBytes = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Memory used: " + "\t\t" + usedBytes + " bytes ("+ usedBytes/1048576.0 +" Megabytes)");

    }

    public static int logsHandler (String patchToLogFiles) throws IOException {

        File folder = new File(patchToLogFiles);
        File[] listOfFiles = folder.listFiles();

        int check=0;

        if (listOfFiles.length<=0) {
            System.out.println("Nothing to proceed here: " + patchToLogFiles);
        }

        for (int i = 0; i < listOfFiles.length; i++) {

            //System.out.println("Number of files: " + listOfFiles.length);

            if (listOfFiles[i].isFile()) {
                System.out.println("File: " + listOfFiles[i].getName());

                String logContent;
                logContent = new String(Files.readAllBytes(Paths.get(patchToLogFiles +"/"+ listOfFiles[i].getName())));
                System.out.println(logContent+"\n");
                System.out.println("111");

                if ( logContent.contains("4")) {

                    check = check + 1;
                    System.out.println("+" + check);

                }

            }

        System.out.println("Files processed: " + "\t" + (i+1));

        }

        return listOfFiles.length;
    }





}

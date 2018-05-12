import javax.sound.midi.Patch;
import java.io.*;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.function.Consumer;
import java.nio.file.Path;
import java.io.IOException;
import java.util.stream.Stream;

public class L401_LogsHandler_v04 {

    public static void main(String[] args) throws IOException {

        // Robert, 10:50 PM
        // привет выода:
        // Feb  1 05:48:35 : Metro-1,Metro-11,Metro-12,Metro-13,Metro-15,Metro-2,Metro-28,Metro-3,Metro-33,Metro-4,Metro-5,Metro-8,Metro-9

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

        long usedBytes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Memory Used: " + "\t\t" + usedBytes + " bytes (" + usedBytes / 1048576.0 + " Megabytes)");

    }

    public static int logsHandler(String patchToLogFiles) throws IOException {

        File folder = new File(patchToLogFiles);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles.length <= 0) {
            System.out.println("Nothing to proceed here: " + patchToLogFiles);
        }

        for (int i = 0; i < listOfFiles.length; i++) {

            //System.out.println("Number of files: " + listOfFiles.length);

            if (listOfFiles[i].isFile()) {
                System.out.println("File name: " + listOfFiles[i].getName());

                try {
                    File file = new File(patchToLogFiles +"/"+ listOfFiles[i].getName());
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    StringBuffer stringBuffer = new StringBuffer();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuffer.append(line);
                        stringBuffer.append("\n");
                    }
                    fileReader.close();
                    System.out.println("Contents of file:");
                    System.out.println(stringBuffer.toString());

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            System.out.println("Files Processed: " + "\t" + (i + 1));

        }

        return listOfFiles.length;
    }


}

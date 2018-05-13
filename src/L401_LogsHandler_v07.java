import java.io.*;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class L401_LogsHandler_v07 {

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

        //logsHandler("Logs");

        logsConverter(logsHandler("Logs"));

        System.out.println("Execution Time: " + "\t" + (System.currentTimeMillis() - startTime) + " milliseconds");

        long usedBytes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Memory Used: " + "\t\t" + usedBytes + " bytes (" + usedBytes / 1048576.0 + " Megabytes)");

    }

    // logsHandler
    // TODO: 5/12/18 add logsHandler description
    //

    public static String logsHandler(String patchToLogFiles) {

        File folder = new File(patchToLogFiles);
        File[] listOfFiles = folder.listFiles();

        StringBuffer stringBufferOut = new StringBuffer();

        int linesAll = 0, linesValuable = 0;

        if (listOfFiles.length <= 0) {
            System.out.println("Nothing to proceed here: " + patchToLogFiles);
        }

        for (int i = 0; i < listOfFiles.length; i++) {

            if (listOfFiles[i].isFile()) {
                System.out.println("File name: " + listOfFiles[i].getName());

                try {
                    File file = new File(patchToLogFiles +"/"+ listOfFiles[i].getName());
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    StringBuffer stringBuffer = new StringBuffer();
                    String line;

                    while ((line = bufferedReader.readLine()) != null) {

                        linesAll = linesAll + 1;

                        String strPattern = "(\\s*)?(Captured transactions:)(\\s*)?($)";

                        Pattern p = Pattern.compile(strPattern);
                        Matcher m = p.matcher(line);

                        if (m.find()) {
                            String line2 = bufferedReader.readLine();
                            stringBuffer.append(line2);
                            stringBuffer.append("\n");

                            linesValuable = linesValuable + 1;

                        } else {
                            //System.out.println("no matches(((");
                        }

                    }
                    fileReader.close();
                    System.out.println("Valuable content of the file: " + "\n");
                    System.out.println(stringBuffer.toString());
                    stringBufferOut = stringBuffer;

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            System.out.println("Files Processed: " + "\t" + (i + 1));
            System.out.println("All lines: " + linesAll +"; Valuable Lines: "+ linesValuable + "; Ratio (%): "+ linesValuable*100.0/linesAll + "\n");


        }
        //System.out.println(stringBufferOut.toString());

        return stringBufferOut.toString();
    }




    // logsConverter
    // TODO: 5/13/18 add logsConverter description and write it ))
    //

    public static String logsConverter (String inRawValuableLogs) {

        String content1 = inRawValuableLogs.replaceAll("(\\n)", "//");
        String content2 = content1.replaceAll("(\\s+)", "/");
        String content3 = content2.replaceAll("//", "\n");

        System.out.println(content3.toString()+"\n");

        String[] arrDate = content3.split("/");


        String outPreparedToStoreLogs = "";
        return  arrDate[0] + " " + arrDate[1] + " " + arrDate[2] + " : " + arrDate[4];
    }



    // logsSaver
    // TODO: 5/13/18 add logsSaver description and write it too
    //

    public static Boolean logsSaver (String inPreparedToStoreLogs) {

        return true;
    }







}

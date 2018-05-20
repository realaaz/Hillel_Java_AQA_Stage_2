import java.io.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class L401_LogsHandler_v083 {

    public static void main(String[] args) throws IOException {

        // Robert, 10:50 PM
        // привет. вывода:
        // Feb  1 05:48:35 : Metro-1,Metro-11,Metro-12,Metro-13,Metro-15,Metro-2,Metro-28,Metro-3,Metro-33,Metro-4,Metro-5,Metro-8,Metro-9

        // 0 get list of log files on the stable patch
        // 1 get count of log files
        // 2 parser log files up to last file
        // 3 regex - needed search string (?)
        // 4 prepare out file (create/close+permissions)
        // 6 println searched lines by log file (1by1)
        // 7 store searched string from logs to out file (bulk)
        // 8 store/out own logs of handler working ?? :)
        // add sorting ??
        // add lines checker - glue lines with same date todo

        long startTime = System.currentTimeMillis();

        logsHandler("Logs");

        System.out.println("Execution Time: " + "\t" + (System.currentTimeMillis() - startTime) + " milliseconds");

        long usedBytes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Memory Used: " + "\t\t" + usedBytes + " bytes (" + usedBytes / 1048576.0 + " Megabytes)");

    }

    // logsHandler

    public static Boolean logsHandler(String patchToLogFiles) throws IOException {

        // reader
        File folder = new File(patchToLogFiles);
        File[] listOfFiles = folder.listFiles();

        StringBuffer stringBufferOut = new StringBuffer();
        StringBuffer stringBuffer = new StringBuffer(); //!!! for stored all buffer - need refactoring

        int linesAll = 0, linesValuable = 0, i;

        // check empty logs folders
        if (listOfFiles.length <= 0) {
            System.out.println("Nothing to proceed here: " + patchToLogFiles);
            return false;
        }

        for (i = 0; i < listOfFiles.length; i++) {

            if (listOfFiles[i].isFile()) {
                System.out.println("File(s) name: " + "\t" + "\t" + listOfFiles[i].getName());

                try {
                    File file = new File(patchToLogFiles + "/" + listOfFiles[i].getName());
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    //StringBuffer stringBuffer = new StringBuffer();
                    String line;

                    // converter
                    while ((line = bufferedReader.readLine()) != null) {

                        linesAll = linesAll + 1;

                        String strPattern = "(\\s*)?(Captured transactions:)(\\s*)?($)";

                        Pattern p = Pattern.compile(strPattern);
                        Matcher m = p.matcher(line);

                        if (m.find()) {

                            String line2 = bufferedReader.readLine();
                            //System.out.println("line2: "+line2);

                            String line3 = line2.replaceAll("(\\s+)", "/");
                            //System.out.println("line3: "+line3);

                            String[] arrToStore = line3.split("/");

                            // check and resolve 1 symbol in day (index[1])
                            if (arrToStore[1].length() == 1) {
                                arrToStore[1] = " " + arrToStore[1];
                            }

                            stringBuffer.append(arrToStore[0] + " " + arrToStore[1] + " " + arrToStore[2] + " : " + arrToStore[5]);
                            stringBuffer.append("\n");



                            // logs gluer - pre alpha-beta-gamma)) - 1 - Hash Map
                            int[][] array = new int[linesValuable][5];

                            array[0][0] = 1;
                            array[0][1] = 2;
                            array[0][2] = 3;
                            array[0][3] = 4;
                            array[0][4] = 5;

//                            for (int ii = 0; ii < array.length; ii++) { // string
//                                for (int j = 0; j < array[ii].length; j++) { // row
//                                    System.out.print(array[ii][j] + "\t");
//                                }
//                                System.out.println("www");
//                            }



                            linesValuable = linesValuable + 1;
                        } else {
                            //System.out.println("no matches(((");
                        }

                    }
                    fileReader.close();




                    ///System.out.println("Valuable content of the file: " + "\n");
                    ///System.out.println(stringBuffer.toString());

                    stringBufferOut = stringBuffer; // ? need to optimize ?

                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }

            }

            ///System.out.println("Files Processed: " + "\t" + (i + 1));
            ///System.out.println("All lines: " + linesAll +"; Valuable Lines: "+ linesValuable + "; Ratio (%): "+ linesValuable*100.0/linesAll + "\n");

        }
        ///System.out.println("Final valuable logs to store: " + "\n");
        ///System.out.println(stringBufferOut.toString());

        System.out.println("File(s) Processed: " + "\t" + i + "\n");
        //System.out.println("All lines: " + linesAll +"; Valuable Lines: "+ linesValuable + "; Ratio (%): "+ linesValuable*100.0/linesAll + "\n");
        System.out.println("Line(s) Processed: " + "\t" + linesAll);
        System.out.println("Valuable Line(s): " + "\t" + linesValuable);
        System.out.println("Ratio (%): " + "\t" + "\t" + "\t" + linesValuable * 100.0 / linesAll + "\n");


        //writer
        try {
            FileWriter writer = new FileWriter("logsOut.file");
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write(stringBufferOut.toString());
            buffer.close();
            System.out.println("logsOut.file:" + "\t" + "\t" + "Stored" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }


        return true;
    }

// change 1
    // change 2 in loggluer


}

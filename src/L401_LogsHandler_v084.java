import java.io.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class L401_LogsHandler_v084 {


    public static class gData {

        public static String patchToLogFiles = "Logs";
        public static File folder = new File(patchToLogFiles);
        public static File[] listOfFiles = folder.listFiles();

        public static StringBuffer stringBuffer = new StringBuffer();
        public static int linesAll = 0, linesValuable = 0, filesCounter = 0;

    }


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        logsFolderChecker();
        logsFilesToValuableStringBuffer();
        logsStringBufferDateOptimizer();
        logsStringBufferTwoWeeklyBuilder();
        logsStringBufferSaver();

        System.out.println("Execution Time: " + "\t" + (System.currentTimeMillis() - startTime) + " milliseconds");
        long usedBytes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Memory Used: " + "\t\t" + usedBytes + " bytes (" + usedBytes / 1048576.0 + " Megabytes)");
    }


    public static Boolean logsFolderChecker() {

        // check empty logs folders
        if (gData.listOfFiles.length <= 0) {
            System.out.println("logsFolderChecker:: Nothing to proceed here: " + gData.patchToLogFiles);
        }

        // print list of files
        for (int i = 0; i < gData.listOfFiles.length; i++) {
            if (gData.listOfFiles[i].isFile()) {
                System.out.println("File(s) name: " + "\t" + "\t" + gData.listOfFiles[i].getName());
            }
        }
        return true;
    }


    public static Boolean logsFilesToValuableStringBuffer() {

        for (gData.filesCounter = 0; gData.filesCounter < gData.listOfFiles.length; gData.filesCounter++) {

            if (gData.listOfFiles[gData.filesCounter].isFile()) {
                //System.out.println("File(s) name: " + "\t" + "\t" + listOfFiles[gData.filesCounter].getName());

                try {
                    File file = new File(gData.patchToLogFiles + "/" + gData.listOfFiles[gData.filesCounter].getName());
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String line;

                    // converter
                    while ((line = bufferedReader.readLine()) != null) {

                        gData.linesAll = gData.linesAll + 1;

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

                            gData.stringBuffer.append(arrToStore[0] + " " + arrToStore[1] + " " + arrToStore[2] + " : " + arrToStore[5]);
                            gData.stringBuffer.append("\n");

                            gData.linesValuable = gData.linesValuable + 1;

                        } else {
                            //System.out.println("no matches(((");
                        }
                    }
                    fileReader.close();
                    // Valuable content of the files
                    //System.out.println(gData.stringBuffer.toString());

                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            ///System.out.println("Files Processed: " + "\t" + (i + 1));
        }
        System.out.println("File(s) Processed: " + "\t" + gData.filesCounter + "\n");
        System.out.println("Line(s) Processed: " + "\t" + gData.linesAll);
        System.out.println("Valuable Line(s): " + "\t" + gData.linesValuable);
        System.out.println("Ratio (%): " + "\t" + "\t" + "\t" + gData.linesValuable * 100.0 / gData.linesAll + "\n");
        return true;
    }


    public static Boolean logsStringBufferDateOptimizer() {

        String[] linez = gData.stringBuffer.toString().split("\\n");

        String[][] arr2X = new String[gData.linesValuable][7];

//  !!!      int aa= 1; // not null ))
//  !!!      for(String s: linez){
//  !!!          System.out.println(aa+ " Content: " + s);
//  !!!          aa = aa +1;
//  !!!      }

        for (int aa = 0; aa < gData.linesValuable; aa++) {
            //System.out.println(aa + " Content1: " + linez[aa]);

//            String line2 = linez[aa].replaceAll(" : ", ":");
//            System.out.println("line2: "+line2);

            String line3 = linez[aa].replaceAll("(\\s+)", "/");
            //System.out.println("line3: "+line3);

            String[] arrToStore = line3.split("/");

            // check and resolve 1 symbol in day (index[1])
            if (arrToStore[1].length() == 1) {
                arrToStore[1] = " " + arrToStore[1];
            }

            arr2X[aa][0] = Integer.toString(aa); // string number
            arr2X[aa][1] = arrToStore[0]; // Month
            arr2X[aa][2] = arrToStore[1]; // Date
            arr2X[aa][3] = arrToStore[2]; // Time
            arr2X[aa][4] = arrToStore[3]; // Separator
            arr2X[aa][5] = arrToStore[4]; // Content
            arr2X[aa][6] = "ok"; // Status

        }

        // so arr2X
        for (int ii = 0; ii < arr2X.length; ii++) { // string
            for (int j = 0; j < arr2X[ii].length; j++) { // row
                System.out.print(arr2X[ii][j] + "\t");
            }
            System.out.println(" ");
        }

        for (int ii = 0; ii < arr2X.length; ii++) { // string

            String sMonth = arr2X[ii][1];
            String sMDate = arr2X[ii][2];
            String sTime  = arr2X[ii][3];

            for (int uu = 0; uu < arr2X.length; uu++) { // string

            }

            System.out.print(arr2X[ii][0] + "\n");
        }


        return true;
    }



    public static Boolean logsStringBufferTwoWeeklyBuilder() {
        return true;
    }


    public static Boolean logsStringBufferSaver() {

        //writer
        try {
            FileWriter writer = new FileWriter("logsOut.file");
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write(gData.stringBuffer.toString());
            buffer.close();
            System.out.println("logsOut.file:" + "\t" + "\t" + "Stored" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}

import java.io.File;

public class L401_LogsHandler_v01 {

    public static void main(String[] args) {

        // 0 get list of log files on the stable patch
        // 1 get count of log files
        fileReader();
        // 2 parser log files up to last file
        // 3 regex - needed search string (?)
        // 4 prepare out file (create/close+permissions)
        // 6 println searched lines by log file (1by1)
        // 7 store searched string from logs to out file (bulk)
        // 8 store own logs of handler working??))

    }

    public static int fileReader () {

        File folder = new File("Logs");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File: " + listOfFiles[i].getName());
            }
//            else if (listOfFiles[i].isDirectory()) {
//                System.out.println("Directory: " + listOfFiles[i].getName());
//            }
        }
        System.out.println("Number of files: " + listOfFiles.length);
        return listOfFiles.length;
    }





}

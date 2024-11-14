import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class DriveWorkOutDataV2HW {
    public static void main(String[] args) throws FileNotFoundException {
        String fName = "workoutsTest.txt";
        ArrayList<String> stringData = getWorkOutData( fName );
        LinkedHashMap<Character, Integer> multPerIntensity = getMultPerIntensity();
        ArrayList<HashMap<Character,Integer>> byWeek = countByWeek(stringData);
        showResults( byWeek, multPerIntensity);
    }

    private static void showResults(ArrayList<HashMap<Character, Integer>> byWeek,
                                    LinkedHashMap<Character, Integer> multPerIntensity) {
       //ToDo Output the weekly data in the format provided in the problem
    }

    private static LinkedHashMap<Character, Integer> getMultPerIntensity() {
        LinkedHashMap<Character, Integer> multPerIntensity = new LinkedHashMap<>();
        //ToDo: Set up this HashMap correctly for the problem
        return multPerIntensity;
    }

    private static ArrayList<HashMap<Character, Integer>> countByWeek(ArrayList<String> workOuts) {

        ArrayList<HashMap<Character, Integer>> map = new ArrayList<>();
        // Todo: this is the trickiest method in the homework
        //   You must summarize the weekly data
        //    Each item in the arrayList is a week's worth of H, M, and L total calores
        //   As a Hint I used getWeeklyData() see below, to help out. I suggest you write that too.

        return map;
    }
    private static HashMap<Character, Integer> getWeeklyData(ArrayList<String> workOuts, int weekStart, int weekEnd) {
        // Todo: You don't need to necesarily write this method
        //  I am including it as a hint. I used this method to return 1 weeks of data
        HashMap<Character, Integer> map = new HashMap<>();
        return map;
    }

    private static ArrayList<String> getWorkOutData( String inFile ) throws FileNotFoundException {
        // You can use this method to input your data.
        // Make sure FileIO.java is in the same directory
        FileIO fio = new FileIO( inFile );
        ArrayList<String> retData = fio.getFileData();
        try {
            fio.setFileData();
        } catch(FileNotFoundException e) {
            System.out.printf("FileNot Found %s", inFile);
            System.exit(1);
        }
        return retData;
    }
}

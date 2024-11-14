import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class DriveWorkOutDataHW {
    public static void main(String[] args) throws FileNotFoundException {
        String fName = "workoutsTest.txt";
        ArrayList<String> stringData = getWorkOutData( fName );
        LinkedHashMap<Character, Integer> multPerIntensity = getMultPerIntensity();
        ArrayList<HashMap<Character,Integer>> byWeek = countByWeek(stringData);
        showResults( byWeek, multPerIntensity);
    }

    private static void showResults(ArrayList<HashMap<Character, Integer>> byWeek,
                                    LinkedHashMap<Character, Integer> multPerIntensity) {
        int week = 1;
        System.out.printf("\n ---- ---- Weekly Totals ---- ----");
        for( HashMap<Character, Integer> wMap : byWeek ) {
            double weekLoad = 0;
//            for( Character c : wMap.keySet() ) {
              for( Character c : multPerIntensity.keySet() ) {
                if ( multPerIntensity.containsKey(c) ) {
                    int mult = multPerIntensity.get(c);
                    int mins = 0; double fract = 0.0;
                    if ( wMap.containsKey( c )) {
                        mins = wMap.get(c);
                        fract = (double) mins / 60;
                    }
                    int displayMin = 0;
                    if ( wMap.containsKey( c )) {
                        displayMin = wMap.get(c);
                    }
                    System.out.printf("\n - Intensity:%s Total min:%s Calories:%3.2f", c, displayMin, (fract*mult));
                    weekLoad += fract * mult;
                } else {
                    System.out.printf("\n Not got key:%s<<--", c);
                    for( Character key : multPerIntensity.keySet() ) {
                        System.out.printf("\n key dump:%s", key);
                    }
                    System.exit(1);
                }
            }
            System.out.printf("\n----- Week:%s Total Calories:%2.2f", week++, weekLoad);
        }
    }

    private static LinkedHashMap<Character, Integer> getMultPerIntensity() {
        LinkedHashMap<Character, Integer> multPerIntensity = new LinkedHashMap<>();
        multPerIntensity.put('H', 600 );
        multPerIntensity.put('M', 400);
        multPerIntensity.put('L', 200);
        return multPerIntensity;
    }

    private static ArrayList<HashMap<Character, Integer>> countByWeek(ArrayList<String> workOuts) {
        int week = 0;
        int ct = 0;
        int numWeeks = workOuts.size() /7;
        int leftOver = workOuts.size() % 7;
        int lastI = 0;
        if (leftOver > 0) {
            lastI = numWeeks;
            numWeeks += 1;
        }
        ArrayList<HashMap<Character, Integer>> map = new ArrayList<>();
        int weekStart = 0;
        int weekEnd = 0;
        for ( int i = 0; i < numWeeks; i++ ) {
            weekStart = week*7;
            if ( leftOver > 0 && i == lastI){

              weekEnd = weekStart + leftOver;
            } else {

                weekEnd = weekStart + 7;
            }
            HashMap<Character,Integer> weekly = getWeeklyData( workOuts, weekStart, weekEnd);
            week++;
            map.add(weekly);
        }

        return map;
    }
    private static HashMap<Character, Integer> getWeeklyData(ArrayList<String> workOuts, int weekStart, int weekEnd) {
        HashMap<Character, Integer> map = new HashMap<>();
        for( int i = weekStart; i < weekEnd; i++ ) {
            if ( i > workOuts.size()){
                break;
            }
            String wLine = workOuts.get(i);
            String[] toks = wLine.split(",");
            Character c = toks[1].charAt(0);
            Integer v = Integer.parseInt(toks[0]);
            if  ( !map.containsKey(c) ) {
                map.put(c, v);
            } else {
                map.put(c, map.get(c) + v);
            }
        }
        return map;
    }

    private static ArrayList<String> getWorkOutData( String inFile ) throws FileNotFoundException {
        //ToDo:
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

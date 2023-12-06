import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// cisco interview question
//* Example input: [{5, ON}, {7, OFF}, {30, ON}, {31, OFF}, {36, ON}]
//        * Example output: [{5, 7}, {30, 31}]
public class SolutionOfflineInterval {
    private static int ON = 1;
    private static int OFF = 0;

    public static void main(String[] args) {
        List<int[]> statuses = toListFrom2dArray(new int[][] {{5, ON}, {7, OFF}, {30, ON}, {31, OFF}, {36, ON}});
        System.out.println(listToString(offlineIntervals(statuses)));
    }

    public static String listToString(List<int[]> arr) {
        return arr.stream().map(a -> Arrays.toString(a)).toList().toString();
    }

    public static List<int[]> toListFrom2dArray(int[][] a) {
        List<int[]> outList = new ArrayList<int[]>();

        for (int i = 0; i < a.length; i++) {
            outList.add(a[i]);
        }

        return outList;
    }

    public static List<int[]> offlineIntervals(List<int[]> statuses) {
        List<int[]> offlineIntervals = new ArrayList<>();
//
//        List<int[]> offlineIntervals = new ArrayList<>();

        int n = statuses.size();
        int prevStatus = statuses.get(0)[1];
        int offlineStart = -1;

        for (int i = 1; i < n; i++) {
            int[] current = statuses.get(i);
            int currentTime = current[0];
            int currentStatus = current[1];

            if (prevStatus == ON && currentStatus == OFF) {
                // Transition from ON to OFF, start of an offline interval
                offlineStart = currentTime;
            } else if (prevStatus == OFF && currentStatus == ON) {
                // Transition from OFF to ON, end of an offline interval
                int[] offlineInterval = {offlineStart, currentTime - 1};
                offlineIntervals.add(offlineInterval);
            }

            prevStatus = currentStatus;
        }

        return offlineIntervals;
    }



}

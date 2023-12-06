package sliding_window_problems;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstNegative {
    public static void main(String[] args) {
        int N = 8;
        long[] A = {12, -1, -7, 8, -15, 30, 16, 28};
        int K = 3;

        Compute computeObject = new Compute();
        long[] result = computeObject.printFirstNegativeInteger(A, N, K);

        System.out.println("Output: " + Arrays.toString(result));
    }
}

class Compute {

    public long[] printFirstNegativeInteger(long A[], int N, int k) {
        int end = 0, start = 0, cntr = 0;
        long res[] = new long[N - k + 1];  //no of slide is the no of ans size
        ArrayList<Long> al = new ArrayList<>();
        if (N == 0)     //corner case
            return res;
        // long res[]=new long[N-K+1];
        while (end < N) {
            if (A[end] < 0)      //if elemnt is less than 0 sotre in list,useful later
                al.add(A[end]);  //always take new elemtn here
            if (end - start + 1 < k) {   //if window size is not hit, slide the window
                end++;
            }

            else if (end - start + 1 == k) {         //if windlow size hits
                if (al.size() == 0)   //if nothing is stotrd in list
                    res[cntr++] = 0;     //just sotre 0 in ans list,stated in qusn
                else {
                    res[cntr++] = al.get(0);  //otherwise take the first elemt of list
                    if (al.get(0) == A[start])   //removing the element from list also if we slide
                        al.remove(A[start]);       //the window to right and the element is same
                }
                start++;
                end++;
            }

        }
        // for(long a:al)
        //     System.out.print(a+" ");
        return res;
    }
}

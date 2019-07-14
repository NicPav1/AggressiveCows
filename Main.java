import java.util.*;

public class Main {

    public static void main(String[] args) throws java.lang.Exception{

        Scanner scan = new Scanner(System.in);

        int testCases = scan.nextInt();

        while (testCases-- > 0){

            int numStalls = scan.nextInt();
            int numCows = scan.nextInt();

            int[] stalls = new int[numStalls];

            for (int i = 0; i < numStalls; i++){
                stalls[i] = scan.nextInt();
            }
            
            Main aggressiveCows = new Main();

            int answer = aggressiveCows.solution(stalls, numStalls, numCows);
            System.out.println(answer);
        }
    }

    private int solution(int[] array, int numCells, int numCows){
        Arrays.sort(array);
        int low = 0;
        int high = array[numCells-1]-array[0]+1;
        while (high - low > 1){
            int mid = (high+low)>>1;
            if (isValid(array, mid, numCows)){
                low=mid;
            }
            else{
                high = mid;
            }
        }
        return low;
    }

    private boolean isValid(int[] array, int d, int c){

        int count = 1;
        int lastCow = array[0];
        for (int i = 1; i < array.length; i++){

            if (array[i]-lastCow >= d){
                count++;
                lastCow = array[i];
            }
        }
        return count >= c;
    }
}
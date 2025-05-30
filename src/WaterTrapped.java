import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class WaterTrapped {
    //{2, 1, 5, 3, 1, 0, 4}
    //lm - 4
    //rm - 8
    //res = 1

    public int calculate(int[] arr){
        int res = 0;
        int left = 1;
        int right = arr.length - 2;

        int leftMax = arr[left-1];
        int rightMax = arr[right+1];

        while (left <= right) {
            //calculate the left max here
            if(leftMax < arr[left]){
                leftMax = arr[left];
                left ++;
                continue;
            }
            if(rightMax < arr[right]){
                rightMax = arr[right];
                right --;
                continue;
            }
            if(leftMax <= rightMax){
                //calculate for left.
                res+= leftMax - arr[left];
                left++;
            }
            else if(leftMax > rightMax){
                //calculate for right.
                res+= rightMax - arr[right];
                right--;
            }
        }
        return res;

    }
}

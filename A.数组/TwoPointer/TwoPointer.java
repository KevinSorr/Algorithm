import java.util.HashMap;
import java.util.Map;

/**
 * Created by ydm on 2017/6/9.
 *  LeetCode 209  Minimum Size Subarray Sum  双索引(滑动窗口)
 *  给定一个整型数组和一个数字s，找到数组中最短的一个连续子数组，
 *  使得连续子数组的数字和sum>=s,返回这个最短的连续子数组的长度值
 *  如：给定数组[2,3,1,2,4,3] ,s = 7
 *  答案为[4,3] 返回2
 */
public class TwoPointer {
    //hashMap
    public int[] twoPointer(int[] array, int target) {
        int[] index = new int[2];
        int left=0,right = 0;
        int sum = 0;
        int min = array.length + 1;

        while (left < array.length){
            //1.处理区间
            if(sum < target && right < array.length){
                sum += array[right++];
            }else{
                sum -= array[left++];
            }
            //2.处理最小值
            if(sum >= target){

                min = minDis(index,left,right,min);
                printArray(array,left,right,sum,min);
            }
        }
        return index;
    }

    private int minDis(int[] index,int left,int right,int min){
        if(min > right - left){
            index[0] = left;
            index[1] = right-1;
            return right - left;
        }
        return min;
    }

    private void printArray(int[] array,int left,int right,int sum,int min){
        for(int i = left;i < right;i++){
            System.out.print(array[i]+",");
        }
        System.out.println("Left:"+left+"===Right:"+right+"====>>>Sum:"+sum+"===>min:"+min);
    }


    public static void main(String[] args) {
        int[] numbers = {2, 3, 1, 2,4,3};
        int[] result = new TwoPointer().twoPointer(numbers, 7);
        for (int i = 0; i < result.length; i++) {
            System.out.println(numbers[result[i]]);
        }


    }
}

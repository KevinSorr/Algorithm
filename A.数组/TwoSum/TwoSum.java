import java.util.HashMap;
import java.util.Map;

/**
 * Created by ydm on 2017/6/9.
 * LeetCode 161 Two Sum II -- Input Array is sorted
 * 给定一个      有序 (可考虑二分查找 nLogn)
 * 整型数组和一个整数target，
 * 在其中寻找两个元素，
 * 使其和为target，
 * 返回这两个数的索引
 * ----如：numbers = [2,7,11,15],target = 9
 * 返回数字2，7 的索引1，2 索引从1开始
 */
public class TwoSum {
    //hashMap
    public int[] twoSum(int[] array, int target) {
        int[] index = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            if (map.get(target - value) != null) {
                index[0] = map.get(target - value) + 1;
                index[1] = i + 1;
                return index;
            } else {
                map.put(value, i);
            }
        }
        return index;
    }

    //对撞指针
    public int[] twoSumPointer(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int[] index = new int[2];
        while (left < right) {
            if (array[left] + array[right] == target) {
                index[0] = left+1;
                index[1] = right+1;
                return index;
            } else if (array[left] + array[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int[] result = new TwoSum().twoSum(numbers, 9);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        result = new TwoSum().twoSumPointer(numbers, 9);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}

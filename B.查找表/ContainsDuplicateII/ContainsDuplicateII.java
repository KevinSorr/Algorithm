import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 查找表+滑动窗口
 * Created by ydm on 2017/6/12.
 * LeetCode 219  Contains Duplicate II
 * 给出一个整型数组nums和一个整数k，是否存在索引i和j，使得nums[i] == nums[j]
 * 且i和j之间的差不超过k
 */
public class ContainsDuplicateII {
    //暴力解法
    public boolean ContainsDuplicateII(int[] array, int k) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length && j - i < k; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    //查找表+滑动窗口
    public boolean ContainsDuplicateII2(int[] array, int k) {
        Set<Integer> records = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (records.contains(array[i])) {
                return true;
            } else {
                records.add(array[i]);
            }
            if(records.size() == k + 1){
                records.remove(array[i - k]);
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //HashMap要比HashSet快
        Map<Integer,Integer> records = new HashMap<Integer,Integer>();
        for(int i =0; i < nums.length;i ++){
            if(records.get(nums[i]) != null){
                return true;
            }
            records.put(nums[i],1);
            if(records.keySet().size() == k + 1){
                records.remove(nums[i-k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 4, 1, 6};
        System.out.println(new ContainsDuplicateII().ContainsDuplicateII2(array, 2));
    }
}

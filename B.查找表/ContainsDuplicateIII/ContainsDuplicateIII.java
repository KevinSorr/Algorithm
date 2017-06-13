import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 二叉搜索树底层实现顺序
 * LeetCode 220  Contains Duplicate III
 * 给出一个整型数组nums和一个整数k，是否存在索引i和j，使得nums[i] 与 nums[j]
 * 之间的差不超过给定的整数t，且i和j之间的差别不超过给定的整数k
 */
public class ContainsDuplicateIII {
    //查找表+滑动窗口
    public boolean ContainsDuplicateII2(int[] array, int k, int t) {
        TreeSet<Integer> records = new TreeSet<>();
        for (int i = 0; i < array.length; i++) {
            if (records.size() > 1
                    && records.last() - records.first() <= t) {
                return true;
            } else {
                records.add(array[i]);
            }
            if (records.size() == k + 1 ) {
                records.remove(array[i - k]);
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        final TreeSet<Long> values = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {

            final Long left = values.floor(Long.valueOf(nums[i] + t));
            final Long right = values.ceiling(Long.valueOf(nums[i] - t));
            if ((left != null && left >= nums[i])
                    || (right != null && right <= nums[i])) {
                return true;
            }

            values.add(Long.valueOf(nums[i]));
            if (i >= k) {
                values.remove(nums[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] array = {7, 2, 8};
        System.out.println(new ContainsDuplicateIII().ContainsDuplicateII2(array, 2, 1));
    }
}

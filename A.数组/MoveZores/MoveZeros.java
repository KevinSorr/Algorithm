/**
 * Created by ydm on 2017/6/7.
 *
 * LeetCode 283 MoveZeros
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *            For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 *
 * Note:
 *        You must do this in-place without making a copy of the array.
 *        Minimize the total number of operations.
 * Credits:
 *      Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 */
public class MoveZeros {
    //1.双指针 left记录第一个零的位置  right循环遍历数据
    public int[] moveZeros(int[] arrays){
        if (arrays == null || arrays.length == 0) return null;
        int left = 0,right =  0;
        while (right < arrays.length){
            if(arrays[left] == 0 && arrays[right] != 0){
                int temp = arrays[left];
                arrays[left] = arrays[right];
                arrays[right] = temp;
            }
            if(arrays[left] != 0){
                left++;
            }
           right++;
        }
        return arrays;
    }
    //2.用不为零的数据将前面数据覆盖掉，后面全为0
    public int[] moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return nums;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
        return nums;
    }


    public static void main(String[] args) {
        int[] arrays = {0, 1, 0, 3, 12};
        int[] value = new  MoveZeros().moveZeros(arrays);
        for(int i :value){
            System.out.print(i+",");
        }

    }
}

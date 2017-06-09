import java.util.HashMap;

/**
 * Created by ydm on 2017/6/9.
 * LeetCode 3 Longest Substring Without Repeating Character
 * <p>
 * 在一个字符串中寻找没有重复字母的最长子串
 * <p>
 * 如："abcabcbb" 则结果为"abc"
 * <p>
 * 如："bbbb" 结果为b
 * <p>
 * 如 ："pwwkew" 结果为"wke"
 */
public class TwoPointer2 {
    //hashMap
    public int[] twoPointer(Character[] array) {
        int[] index = new int[2];
        int left = 0;
        int right = 0;
        int max = 0;
        HashMap<Character,Integer> values = new HashMap<>();
        while ( left <  array.length){
            if( right < array.length && values.get(array[right]) == null) {
                values.put(array[right],1);
                right++;
            }else{
                values.remove(array[left]);
                left++;
            }
            max = maxDis(index,left,right,max);
            printArray(array,left,right,max);
        }

        return index;
    }

    private int maxDis(int[] index, int left, int right, int max) {
        if (max < right - left) {
            index[0] = left;
            index[1] = right - 1;
            return right - left;
        }
        return max;
    }

    private void printArray(Character[] array, int left, int right, int max) {
        for (int i = left; i < right; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println("Left:" + left + "===Right:" + right + "===>max:" + max);
    }


    public static void main(String[] args) {
        Character[] numbers = {'a', 'b', 'c', 'a', 'b', 'c', 'b', 'b'};
        //Character[] numbers = {'b', 'b', 'b'};
        int[] result = new TwoPointer2().twoPointer(numbers);
        for(int i = result[0];i <= result[1];i++){
            System.out.print(numbers[i]);
        }



    }
}

/**
 * Created by ydm on 2017/6/9.
 * 三路快排：
 * 给定一个有n个元素的数组，数组中元素的取之只有0,1,2三种可能。
 *
 */
public class SortColors2 {

    public int[] sortColors(int[] array) {
        int zero = -1;
        int two = array.length;
        for (int i = 0; i < two; ) {
            int value = array[i];
            if (value == 1) {
                i++;
            } else if (value == 0) {
                //++zero 先加  再传值
                //i++先传值 再加
                array = swap(array, ++zero, i++);
            } else if (value == 2) {
                array = swap(array, --two, i);
            }

        }

        return array;
    }

    private int[] swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
        return array;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 0, 1, 2};
        array = new SortColors2().sortColors(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
}

/**
 * Created by ydm on 2017/6/9.
 * 计数排序：(循环两次)
 * 给定一个有n个元素的数组，数组中元素的取之只有0,1,2三种可能。为这个数组排序
 */
public class SortColors {

    public int[] sortColors(int[] array) {
        int[] num = new int[3];

        for (int i = 0; i < array.length; i++) {
            if(array[i] >= 0 && array[i] <= 2){
                num[array[i]]++;
            }else {
                System.out.println("输入有问题");
                return  null;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (i < num[0]) {
                array[i] = 0;
            } else if (i < num[0] + num[1]) {
                array[i] = 1;
            } else {
                array[i] = 2;
            }

        }
        return array;
    }

    public static void main(String[] args) {
        int [] array = {0,1,2,0,1,2};
        array = new SortColors().sortColors(array);
        for(int i = 0; i < array.length;i++){
            System.out.print(array[i]+",");
        }
    }
}

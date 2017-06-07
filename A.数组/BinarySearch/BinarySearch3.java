
/**
 * Created by ydm on 2017/6/7.
 * 二分查找：
 *      对于有序数列  常采用此方法
 *
 * 注意：处理边界与索引指向问题
 *
 * 更改左右区间
 */
public class BinarySearch3<T> {

    public int binarySearch(T[] array,int n,T target){
        int left = 0,right = n ;//设置区间为[left,right]
        while (left < right){   //当left == right 时,[left,right)仍然为无效区间


            int mid = left + (right - left) / 2; //避免整型溢出





            if(target == array[mid]){
                return mid;
            }
            if((Integer)target < (Integer) array[mid]){
                right = mid;
            }
            if((Integer)target >(Integer) array[mid]){
                left = mid + 1;
            }

        }

        return  -1;
    }

    public static void main(String[] args) {
        Integer[] arrays = {1,3,4,6,7};
        int value = new BinarySearch3<Integer>().binarySearch(arrays,arrays.length,3);
        System.out.print(value);

    }
}

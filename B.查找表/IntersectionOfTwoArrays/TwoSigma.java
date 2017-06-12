import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by ydm on 2017/6/12.
 *
 * LeetCode  349 给定两个数组nums 求两个数组的公共元素
 * 如：nums1 = [1，2，2，1] nums2= [2,2]
 * 结果为[2]
 * 结果中每个元素只能出现一次
 * 出现的顺序可以是任意的
 */

public class TwoSigma {

    public Set<Integer> insertSection(int[] array1,int[] array2){
        Set<Integer> record = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for(int i = 0;i < array1.length;i++){
            record.add(array1[i]);
        }
        for(int i = 0; i < array2.length;i++){

            if(record.contains(array2[i])){
                result.add(array2[i]);
            }
        }
        return result;

    }

    public  static void main(String[] args){
        int[] array1 = {1,2,2,1};
        int[] array2 = {2,2};
        Set<Integer> result  = new TwoSigma().insertSection(array1,array2);
        Iterator<Integer> list = result.iterator();
        while (list.hasNext()){
            System.out.println(list.next());
        }
    }
}

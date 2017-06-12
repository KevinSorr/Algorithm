import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by ydm on 2017/6/12.
 * Leetcode 350 Intersection of Two Arrays
 * 给定两个数组nums 求两个数组的交集
 * 如：nums1=[1,2,2,1] nums2 = [2,2]
 * 结果为[2,2]
 * 出现的顺序可以是任意的
 */
public class TwoSimaMap {

    public Map<Integer,Integer> getNums(int[] array1,int[] array2){
        Map<Integer,Integer> record1 = new HashMap<>();
        for (int i =  0;i < array1.length;i++){
            if(record1.get(array1[i]) != null){
                record1.put(array1[i],record1.get(array1[i])+1);
            }else{
                record1.put(array1[i],1);
            }

        }
        Map<Integer,Integer> result = new HashMap<>();
        for (int i = 0;i < array2.length;i++){

            if(record1.containsKey(array2[i])){
                if(result.get(array2[i]) != null){
                    result.put(array2[i],result.get(array2[i])+1);
                }else{
                    result.put(array2[i],1);
                }
            }


        }
        return result;
    }

    public static void main(String[] args){
        int[] array1 = {1,2,2,1};
        int[] array2 = {2,2,1};
        Map<Integer,Integer> result = new TwoSimaMap().getNums(array1,array2);
        Set<Integer> keys = result.keySet();
        for (Integer key:keys){
            for(int i = 0; i < result.get(key);i++){
                System.out.println(key);
            }

        }

    }
}

import java.util.*;

/**
 * Created by ydm on 2017/6/14.
 * LeetCode 347 Top K Frequent Elements
 * 给定一个非空数组  返回前k个出现频率最高的元素
 */
class Num{
    int time;
    int value;

    public Num(int time, int value) {
        this.time = time;
        this.value = value;
    }
}
public class TopKFrequentElements {

    public  int[]  TopKFrequentElements(int[] array,int k){
        int[] list = new int[k];
        Queue<Num> integers = new PriorityQueue<>(k,numComparator);
        HashMap<Integer,Integer> nums = new HashMap<>();
        for(int i = 0; i  < array.length;i ++){
            if(nums.get(array[i]) != null){
                nums.put(array[i],nums.get(array[i])+1);
            }else{
                nums.put(array[i],1);
            }
            integers.offer(new Num(nums.get(array[i]),array[i]));
        }
        for(int i =0; i < k;i ++){
            Num num = integers.poll();
            if(num != null){
                System.out.println(num.value+","+num.time);
            }
            list[i] = num.value;
        }

        return list;
    }

    private Comparator<Num> numComparator = new Comparator<Num>() {
        @Override
        public int compare(Num o1, Num o2) {
            return o2.time - o1.time;
        }
    };

    public static void main(String[] args){
        int[] integers = {2,2,4,54,6,6,6,3,12};
        int[] list = new TopKFrequentElements().TopKFrequentElements(integers,2);
        for(Integer integer : list){
            System.out.println(integer);
        }
    }

}

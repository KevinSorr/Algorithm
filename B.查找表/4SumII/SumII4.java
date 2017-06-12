import java.util.HashMap;
import java.util.Map;

/**
 * Created by ydm on 2017/6/12.
 *
 * LeetCode 454    4SumII
 *   给出四个整型数组A,B,C,D，寻找有多少个i,j,k,z的组合，使得A[i]+B[j]+C[k]+D[j]==0
 *   其中，A,B,C,D中均含有相同的元素个数N,且0<=N<=500
 */
public class SumII4 {

    public int fourSumCount(int[] A ,int[] B,int[] C,int[] D){
        Map<Integer,Integer> records = new HashMap<>();
        for(int i = 0;i  < A.length;i++){
            for(int j = 0;j < B.length;j++){
                int value = A[i] + A[j];
                if(records.get(value) != null ){
                    records.put(value,records.get(value)+1);
                }else{
                    records.put(value,1);
                }
            }
        }
        int sum = 0;
        for(int i = 0;i <C.length;i++){
            for(int j = 0;j < D.length;j++){
                int value = C[i]+ D[j];
                if(records.get(0- value) != null){
                    sum+= records.get(0-value);
                }
            }
        }
        return sum;

    }
    public static void main(String[] args){
        int[] A = {1,2,4,5};
        int[] B = {1,2,4,5};
        int[] C = {-1,-2,4,5};
        int[] D = {-1,-2,4,5};
        System.out.println(new SumII4().fourSumCount(A,B,C,D));

    }
}

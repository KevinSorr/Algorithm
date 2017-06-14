import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by ydm on 2017/6/14.
 * LeetCode 279 Perfect Squares
 * 给出一个正整数n ，寻找最少的完全平方数，使他们和为n
 * 完全平方数：1，4，9，16
 * 12=4+4+4
 * 13=4+9
 *
 * 构造图 求最短路径
 */
class Number{
    int value;
    int step;

    public Number(int value, int step) {
        this.value = value;
        this.step = step;
    }
}
public class PerfectSquares {


    public int PerfectSquares(int value){
        Queue<Number> mQueue = new LinkedBlockingQueue<>();
        mQueue.offer(new Number(value,0));
        int[] flag = new int[value+1];
        while (!mQueue.isEmpty()){
            Number number = mQueue.poll();
            int num = number.value;
            int step = number.step;

            if(num == 0 ){
                return step;
            }
            int temp ;
            for(int i = 1;(temp =  num - i * i)>= 0;i++){
                if(temp == 0){
                    return step + 1;
                }
                if(flag[temp] == 0){
                    mQueue.add(new Number(temp,step+1));
                    flag[temp] = 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args){
        System.out.println(new PerfectSquares().PerfectSquares(4));
    }
}

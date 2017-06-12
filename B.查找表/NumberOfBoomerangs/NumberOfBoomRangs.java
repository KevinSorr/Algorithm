import java.nio.channels.Pipe;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by ydm on 2017/6/12.
 * <p>
 * LeetCode 454    4SumII
 * 给出四个整型数组A,B,C,D，寻找有多少个i,j,k,z的组合，使得A[i]+B[j]+C[k]+D[j]==0
 * 其中，A,B,C,D中均含有相同的元素个数N,且0<=N<=500
 */
class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class NumberOfBoomRangs {

    public int NumberOfBoomRangs(Point[] points) {
        int sum = 0;

        for (int i = 0; i < points.length; i++) {
            HashMap<Integer, Integer> records = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int dis = disPoint(points[i], points[j]);
                    if (records.get(dis)  == null) {
                        records.put(dis,1);
                    }else{
                        records.put(dis,records.get(dis)+1);
                    }

                }
            }
            Set<Integer> keys = records.keySet();
            for(Integer key:keys){
                int num =  records.get(key);
                sum  = sum + num * (num -1);
            }
        }
        return sum;

    }


    public int disPoint(Point A, Point B) {
        return (B.y - A.y) * (B.y - A.y) + (B.x - A.x) * (B.x - A.x);
    }

    public static void main(String[] args) {
        Point[] points = {new Point(1, 3), new Point(1, 3), new Point(1, 3)};
        System.out.println(new NumberOfBoomRangs().NumberOfBoomRangs(points));
    }
}

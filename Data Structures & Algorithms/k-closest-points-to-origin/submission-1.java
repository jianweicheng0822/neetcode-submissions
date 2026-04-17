class Solution {
    /*
    
    input:  2-D array ->  points[i] =  [xi, yi]

    Rule:

    sqrt((x1 - x2) ^ 2 + (y1 - y2)^2)

    
    Output: return the k closet points to the (0,0)

    Example:
    Happy case:
    points = [[0,2] [2,2]]

    0 + 4 = 4, sqrt(4)  = 2

    4+4 = 8, sqrt(8) = 

    PriortyQueue as max heap to calcuate by this math's rule and store the values.
    poll k closest points return it back

    Edge case:
      1.points is empty or null
      2. k = 0, return any point 
      3. k >  points.length 
   pq : {0,2,2}
    
    */
    static class Point{
        int x;
        int y;
;       double distance;
        Point(int x, int y){
            this.x = x;
            this.y = y;
            this.distance = Math.sqrt(x * x + y * y);
        }
    }
    public int[][] kClosest(int[][] points, int k) {
         PriorityQueue<Point> pq = new PriorityQueue<>((a,b) -> Double.compare(a.distance, b.distance));
         int[][] res = new int[k][2];
         for(int[] point : points){
            pq.offer(new Point(point[0], point[1]));
         }
         int index = 0;
         while(k > 0){
            Point temp = pq.poll();
            res[index] =  new int[]{temp.x, temp.y};
            index++;
            k--;
         }
         return res;

    }
}

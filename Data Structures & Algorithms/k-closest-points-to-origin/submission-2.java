class Solution {
    /*
    
    PQ
    new int[0,2],value

    0,2,
    
    
    */
    static class Point{
        int[] coord;
        double distance;
        Point(int[]coord, double distance){
            this.coord = coord;
            this.distance = distance;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>((a,b) -> Double.compare(a.distance, b.distance));
        for(int[] point : points){
            int x  = point[0];
            int y = point[1];
            double  distance = Math.sqrt(x * x + y * y);
            pq.offer(new Point(new int[]{x,y}, distance));
        }
        int count = 0;
        int[][]res = new int[k][2];
        while(!pq.isEmpty() &&  count < k){
           res[count] = pq.poll().coord;
           count++;
        }
        return res;

    }
}

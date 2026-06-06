class Solution {
    /*
    Input : int[] pos -> , int[] speed 
    
    Output: Return the number of different car fleets 
    
    Example:
    Input: target = 10, position = [4,1,0,7], speed = [2,2,1,1]

    0(speed 1)  10  
       1(speed 2)  4.5  
               4(speed 2)   3 
                        7(speed 1)  3

                        How long does it take to the target?
    sort the car by highest pos first, then I can do the math for time, see if there any car catches up.
    */
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        int[][]cars = new int[n][2];
        for(int i =0; i < n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a,b)-> b[0] - a[0]);
        int carFleet = 0;
        double maxtime = Double.MIN_VALUE;
        for(int[] car : cars){
            int pos = car[0];
            int sp = car[1];
            double time = (double)(target - pos) / sp;
            if(time  > maxtime ){
                carFleet++;
                maxtime = time;
            }
        }
        return carFleet;
    }
}

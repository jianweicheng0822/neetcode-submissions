class Solution {
    /*
    1 2 3 4
    l     r

    
    Edge case:
    numbers == null or numbers.length < 2 
    */
    public int[] twoSum(int[] numbers, int target) {
         if(numbers == null || numbers.length < 2){
            return new int []{};
         }    
         int l =0;
         int r = numbers.length-1;
         while(l < r){
            int n = numbers[l] + numbers[r];
            if(n == target){
                return new int[]{l+1,r+1};
            }
            if(n > target){
                r--;
            }else{
                l++;
            }
         }
         return new int[]{};
    }
}

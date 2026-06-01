class Solution {
    /*
    prices = [10,1,5,6,7,11]
    
    choose a single day to buy it, and a different day to sell it.

   Find the maxProfit.
   Profit = sell(max) - buyin(min)
   prices = [10,1,5,6,7,11]
                        
    int buy = Math.min(prices[i], buy);
    profit =  Math.max(profit, price[i] - buy )
     
    
             
    */
    public int maxProfit(int[] prices) {
        int result = 0;
        int buy = prices[0];
        for(int price : prices){
            buy = Math.min(price, buy);
            result = Math.max(result, price - buy);
        }
        return result;

    }
}

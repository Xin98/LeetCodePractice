class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        int min = prices[0],max = 0;
        for(int i=0,len=prices.length; i<len; i++) {
            min = prices[i]<min?prices[i]:min;
            max = prices[i]-min>max?prices[i]-min:max;
        }
        return max;
    }
}
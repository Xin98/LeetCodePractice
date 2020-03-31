class Solution {
    public int lengthOfLongestSubstring(String s) {
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        String[] strings = s.split("");
        for (int i = 0; i<s.length(); i++){
            int index = stringBuilder.indexOf(strings[i]);
            stringBuilder.append(strings[i]);
            if( index > -1){
                stringBuilder = stringBuilder.delete(0,index+1);
            }else{
                if( stringBuilder.length() > count){
                    count++;
                }
            }
        }
        return count;
    }
}
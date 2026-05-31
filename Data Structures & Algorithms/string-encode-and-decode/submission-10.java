class Solution {
     /*
     Encode
     
     "apple" "banana"
     50#apple6Banana 

     */
    public String encode(List<String> strs) {
       StringBuilder sb = new StringBuilder();
       for(String s : strs){
        sb.append(s.length()).append("#").append(s);
       }
       return sb.toString();
    }
 /*
 
  5#apple6#Banana 
    i
         j

   i = j
   j += length     
length = substring(i,j) when j is #
str = subtring()
 */
    public List<String> decode(String str) {
        int i = 0;
        int j =0;
        List<String> res = new ArrayList<>();
        while(j < str.length()){
            if(str.charAt(j) == '#'){
               int length = Integer.parseInt(str.substring(i,j));
            j++;
            i =j;
            j += length;
            res.add(str.substring(i,j));
            i =j; 
            }else{
                j++;
            }
           
        }       
        return res;
    }
}

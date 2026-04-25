class Solution {
    /*
    inputs : type string, digits 2 - 9

    output : all possible letter combinations that digits.

    Note:
    order matters

    Example:
    "345"
    def  startIndex
   d
  ghi

  Think about how to simulate the process that  we pick d, the next level I pick g, next level I
  pick j

   "34"
   every level we pick one character
   first level  def
    second level ghi

  use the hashmap to faster loop up
    output : List of strings  -> dg dh di eg eh ei fg fh fi
    */
    private Map<Character, String> m = new HashMap<>();
    private List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        m.put('2', "abc");
        m.put('3', "def");
        m.put('4', "ghi");
        m.put('5', "jkl");
        m.put('6', "mno");
        m.put('7', "pqrs");
        m.put('8', "tuv");
        m.put('9', "wxyz");
        backtrack(digits, 0, "");
        return res;
    }
    private void backtrack(String digits, int index, String path) {
          if(index == digits.length()){
              res.add(path);
              return;
          }
          String letter = m.get(digits.charAt(index));
          for(char c : letter.toCharArray()){
            backtrack(digits, index+1, path + c);
          }

    }
}

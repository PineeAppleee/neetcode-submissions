class Solution {
    List<List<String>> subset = new ArrayList<>();
    public List<List<String>> partition(String s) {
        rec(s,0,new ArrayList<>());
        return subset;
    }
    public void rec(String s,int i,List<String> list){
     
     if(i>=s.length()){
        subset.add(new ArrayList<>(list));
        return;
     }
      for(int j = i;j<s.length();j++){
        if(ispalindrome(s,i,j)){
            list.add(s.substring(i,j+1));
            rec(s,j+1,list);
            list.remove(list.size()-1);
        }
      }
      
    }

    public boolean ispalindrome(String str,int i,int j){
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
               return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

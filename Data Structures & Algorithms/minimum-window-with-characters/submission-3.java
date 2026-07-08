class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> store = new  HashMap<>();
        int n = s.length() , m = t.length();
        for(int i = 0;i<m;i++){
          store.put(t.charAt(i),store.getOrDefault(t.charAt(i),0)+1);
        }

        int i = 0;
        int j = 0;
        HashMap<Character,Integer> check_mp = new  HashMap<>();
        int min = (int)1e8;
        String ans = "";


        while(j<n){
        check_mp.put(s.charAt(j),check_mp.getOrDefault(s.charAt(j),0)+1);

        while(i<=j&&checkstore(check_mp,store)){
           
        
            if(min>(j-i+1)){
                min = j-i+1;
                ans = s.substring(i,j+1);
                 System.out.println(min);
            }
            check_mp.put(s.charAt(i),check_mp.getOrDefault(s.charAt(i),0)-1);
            if(check_mp.get(s.charAt(i))==0){
                check_mp.remove(s.charAt(i));
            }
            i++;
        }
        j++;
        }

        return ans;
    }

    boolean checkstore(HashMap<Character,Integer> check_mp,HashMap<Character,Integer> store){
       for(char ch : store.keySet()){
        int val_store = store.get(ch);
        // System.out.println(ch);
        if(!check_mp.containsKey(ch)){
           return false;
        }
         if(check_mp.get(ch) < val_store){
            return false;
        }
       }
       return true;
    }
}

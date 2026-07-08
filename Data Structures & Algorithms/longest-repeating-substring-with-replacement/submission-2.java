int maxfreq = 0;
int totalcount = 0;
HashMap<Character,Integer> mp = new HashMap<>();

void countmaxfreq(){
    maxfreq = 0;
    totalcount = 0;
    for(char ch : mp.keySet()){
        int val = mp.get(ch);
        maxfreq = Math.max(maxfreq,val);
        totalcount += val;
    }
}

class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0;
        int j = 0;
        int n = s.length();
        int max = 0;
        
        int max_char_freq = 0;
        while(j<n){
            char ch = s.charAt(j);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
            //System.out.println(ch+" "+mp.get(ch));
            countmaxfreq();
            int deduction = totalcount-maxfreq; 
            //System.out.println(totalcount+" "+maxfreq);
            while(i<j&&deduction>k){
               mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)-1);
               if(mp.get(s.charAt(i))==0){
                mp.remove(s.charAt(i));
               }
               i++;
               countmaxfreq();
               deduction = totalcount - maxfreq;
            }

            max = Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}

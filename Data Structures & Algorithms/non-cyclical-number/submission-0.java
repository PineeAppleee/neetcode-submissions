class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        
        while(n!=1){
         int ans = n;
         int sum = 0;
         while(ans>0){
           int rem = ans%10;
           sum += rem*rem;
           ans= ans/10;
         }
         if(set.contains(sum)) return false;
         n = sum;
         set.add(sum);
        }

        return true;
    }
}

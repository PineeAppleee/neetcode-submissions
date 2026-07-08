class pair{
    int a,b;
    pair(int a,int b){
        this.a = a;
        this.b = b;
    }
}


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->b.a-a.a);
       for(int i = 0;i<k;i++){
        pq.add(new pair(nums[i],i));
       }
        int n = nums.length;
        int ans[] = new int[n-k+1];
        int i = 0;
        ans[i++] = pq.peek().a;

       for(int j = k; j < n; j++){
         pq.add(new pair(nums[j],j));
         int boundary = j-k+1;
         while(!pq.isEmpty()&&pq.peek().b<boundary){
           pq.poll();
         }
         ans[i++] = pq.peek().a;
       } 

       return ans;
    }
}

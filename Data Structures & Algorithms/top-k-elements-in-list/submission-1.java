class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int x : nums) mp.put(x,mp.getOrDefault(x,0)+1);

        int arr[][] = new int[mp.size()][2];
        int i = 0;
        for(int key : mp.keySet()){
            int val = mp.get(key);
            arr[i][0] = key;
            arr[i][1] = val;
            i++;
        }
        Arrays.sort(arr,(a,b)->b[1]-a[1]);
        int temp[] = new int[k];
        for(i = 0;i<k;i++){
            temp[i] = arr[i][0];
        }
        return temp;
    }
}

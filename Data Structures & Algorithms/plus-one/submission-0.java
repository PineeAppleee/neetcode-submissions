class Solution {
    public int[] plusOne(int[] digits) {
     List<Integer> list = new ArrayList<>();
     int n = digits.length;
     int sum = digits[n-1]+1;
     int left = 0;
     if(sum>9){
         int rem = sum%10;
         left = sum/10;
         list.add(rem);
        }else{
            left = 0;
            list.add(sum);
        }

     for(int i = n-2;i>=0;i--){
        sum = digits[i]+left;
        if(sum>9){
         int rem = sum%10;
         left = sum/10;
         list.add(rem);
        }else{
            left = 0;
            list.add(sum);
        }
        
     }
     if(left!=0) list.add(left);
     Collections.reverse(list);
     int arr[] = new int[list.size()];
     for(int i = 0;i<list.size();i++){
        arr[i] = list.get(i);
     }
     return arr;
    }
}

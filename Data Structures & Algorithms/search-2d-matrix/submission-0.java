class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            //System.out.println(mid);
            if(matrix[mid][0]>target){
                end = mid-1;
            }else if(matrix[mid][0]<target){
                start = mid+1;
            }else{
                return true;
            }
            if(checkrow(matrix,target,mid)){
                    return true;
                }
        }
        return false;
    }

    public boolean checkrow(int [][] matrix,int target, int mid){
        int start = 0;
        int end = matrix[0].length-1;

        while(start<=end){
            int m = start+(end-start)/2;
            if(matrix[mid][m]<target){
                start = m+1;
            }else if(matrix[mid][m]>target){
                end = m-1;
            }else{
                return true;
            }
        }
        return false;
    }
}

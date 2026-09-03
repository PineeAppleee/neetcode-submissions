class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int s = intervals[0][0];
        int e = intervals[0][1];
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > e) {
                list.add(new int[]{s, e});
                s = intervals[i][0];
                e = intervals[i][1];
            } else {
                s = Math.min(s, intervals[i][0]);
                e = Math.max(e, intervals[i][1]);
            }
        }
        list.add(new int[]{s,e});
        return list.toArray(new int[list.size()][]);
    }
}

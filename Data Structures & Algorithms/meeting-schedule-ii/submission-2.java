/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

          if (intervals == null || intervals.size() == 0) {
            return 0;
        }
        
        Collections.sort(intervals,(a,b)->a.start-b.start);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(intervals.get(0).end);

        for (int i = 1; i < intervals.size(); i++) {

            // Earliest room is free
            if (pq.peek() <= intervals.get(i).start) {
                pq.poll();
            }

            // Put current meeting into a room
            pq.add(intervals.get(i).end);
        }

        return pq.size();

    }
}

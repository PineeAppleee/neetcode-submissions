class MedianFinder {
    PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> min_heap = new PriorityQueue<>();

    public MedianFinder() {}

    public void addNum(int num) {
        if (max_heap.isEmpty() || num <= max_heap.peek()) {
            max_heap.offer(num);
        } else {
            min_heap.offer(num);
        }

        // Balance the heaps
        if (max_heap.size() > min_heap.size() + 1) {
            min_heap.offer(max_heap.poll());
        } else if (min_heap.size() > max_heap.size()) {
            max_heap.offer(min_heap.poll());
        }
    }

    public double findMedian() {
        if (max_heap.size() == min_heap.size()) {
            return (max_heap.peek() + min_heap.peek()) / 2.0;
        }
        return max_heap.peek();
    }
}

class Pair {
    String value;
    int timestamp;

    Pair(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}
class TimeMap {
     HashMap<String,List<Pair>> mp;
    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        mp.computeIfAbsent(key, k->new ArrayList<>()).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {

    if (!mp.containsKey(key))
        return "";

    List<Pair> list = mp.get(key);

    int left = 0;
    int right = list.size() - 1;

    String ans = "";

    while (left <= right) {

        int mid = left + (right - left) / 2;

        if (list.get(mid).timestamp <= timestamp) {
            ans = list.get(mid).value;
            left = mid + 1;
        } else {
            right = mid - 1;
        }
     }
    return ans;
    }
}

class Solution {
    List<String> list = new ArrayList<>();
    HashMap<Integer, String> mp = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return list;
        mp.put(2, "abc");
        mp.put(3, "def");
        mp.put(4, "ghi");
        mp.put(5, "jkl");
        mp.put(6, "mno");
        mp.put(7, "pqrs");
        mp.put(8, "tuv");
        mp.put(9, "wxyz");
        rec(digits, 0, new StringBuilder());

        return list;
    }
    public void rec(String digits, int idx, StringBuilder curr) {
        if (idx == digits.length()) {
            list.add(curr.toString());
            return;
        }

        String letters = mp.get(digits.charAt(idx) - '0');

        for (char ch : letters.toCharArray()) {
            curr.append(ch); // Choose

            rec(digits, idx + 1, curr); // Explore

            curr.deleteCharAt(curr.length() - 1); // Undo
        }
    }
}

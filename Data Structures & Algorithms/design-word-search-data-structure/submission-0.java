class TrieNode{
        TrieNode children[]  = new  TrieNode[26];
        boolean endOfWord = false;
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
     root = new TrieNode();
    }


    public void addWord(String word) {
      TrieNode curr = root;
      for(char c : word.toCharArray()){
        int i = c-'a';
        if(curr.children[i]==null){
            curr.children[i] = new TrieNode();
        }
        curr = curr.children[i];
      }
      curr.endOfWord = true;
    }

    public boolean search(String word) {
        return searchInNode(word, 0, root);
    }

    // Helper method for recursive DFS
    private boolean searchInNode(String word, int index, TrieNode curr) {
        if (curr == null) return false;

        if (index == word.length()) {
            return curr.endOfWord;
        }

        char c = word.charAt(index);

        if (c == '.') {
            // Branch out and try all 26 possible children
            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null && searchInNode(word, index + 1, curr.children[i])) {
                    return true;
                }
            }
            return false;
        } else {
            int i = c - 'a';
            return searchInNode(word, index + 1, curr.children[i]);
        }
    }
}

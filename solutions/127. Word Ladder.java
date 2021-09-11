class Solution {
​
public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> set = new HashSet<>();
    
    if (!wordList.contains(endWord)) {
        return 0;
    }
    
    Queue<String> queue = new LinkedList<>();
    queue.offer(beginWord);
    set.add(beginWord);
    int count = 0;
    
    while (!queue.isEmpty()) {
        
        int size = queue.size();
        count++;
        for (int i = 0; i < size; i++) {
            String temp = queue.poll();
            
            if (temp.equals(endWord)) {
                return count;
            }
            for (String word : wordList) {
                if (checkDiffByOne(temp, word) && !set.contains(word)) {
                    queue.offer(word);
                    set.add(word);
                }
            }
        }
    }
    return 0;
}
​
public boolean checkDiffByOne(String temp, String word) {
    int len = temp.length();
    int count = 0;
    
    for (int i = 0; i <len; i++) {
        if (temp.charAt(i) != word.charAt(i)) {
            count++;
        }
    }
    return count == 1 ? true : false;
}
}

package topKFrequentWord;

import java.util.*;

public class Solution {
    static class Node {
        int count;
        String word;

        public Node(int count, String word) {
            this.count = count;
            this.word = word;
        }
    }

    /**
     * 解题思路: 小根堆 + 哈希表
     */
    public static List<String> topKFrequent(String[] words, int k) {
        List<String> ret = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String word : words) hashMap.merge(word, 1, Integer::sum);
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> (a.count == b.count) ? b.word.compareTo(a.word) : a.count - b.count);
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            queue.add(new Node(value, key));
            if (queue.size() > k) {
                queue.poll();
            }
        }
        while (!queue.isEmpty()) {
            ret.add(queue.poll().word);
        }
        Collections.reverse(ret);
        return ret;
    }
}
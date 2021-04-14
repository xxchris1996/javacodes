package acwing.acwing142;

import java.util.Scanner;

public class Main {
    static class Trie{
        private Trie[] children;
//        private boolean isEnd;
        private int cnt;
        public Trie(){
            children = new Trie[26];
//            isEnd = false;
            cnt = 0;

        }
        public void insert(String word){
            Trie node = this;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                int index = ch - 'a';
                if(node.children[index] == null){
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.cnt++;
        }

        public int searchPrefix(String prefix){
            Trie node = this;
            int count = 0;
            for(int i = 0; i < prefix.length(); i++){
                char ch = prefix.charAt(i);
                int index = ch - 'a';
                if(node.children[index] == null) return count+node.cnt;
//                if(node.isEnd) count++;
                count += node.cnt;
                node = node.children[index];
            }
            if (node != null) count += node.cnt;
            return count;
        }
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        Scanner sc = new Scanner(System.in);
        int numInsert = sc.nextInt();
        int numSearch = sc.nextInt();
        int count = 0;
        for(int i = 0; i < numInsert; i++){
            obj.insert(sc.next());
        }
        for(int i = 0; i < numSearch; i++){
            int countPrefix = obj.searchPrefix(sc.next());
            System.out.println(countPrefix);

        }
    }

}

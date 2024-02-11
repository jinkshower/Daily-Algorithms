package ndb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WordCompare {

    static class Word implements Comparable<Word> {

        String content;

        public Word(String content) {
            this.content = content;
        }

        public String getContent() {
            return this.content;
        }

        public int compareTo(Word other) {
            int originL = this.content.length();
            int inputL = other.content.length();
            if (originL > inputL) {
                return 1;
            } else if (originL < inputL) {
                return -1;
            } else {
                return this.content.compareTo(other.content);
            }
        }
    }

    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            if (!list.contains(str)) {
                list.add(str);
            }
        }

        List<Word> wordList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            wordList.add(new Word(list.get(i)));
        }

        Collections.sort(wordList);

        for (Word word : wordList) {
            System.out.println(word.getContent());
        }

    }
}

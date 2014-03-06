package edu.macalester.comp124.wordcounter;

import java.util.Set;

/**
 * A counter that keeps track of counts for all words
 * 
 * @author shilad
 *
 */
public class AllWordsCounter {

    public static final int MAX_WORDS = 10000;

    private SingleWordCounter[] counters = new SingleWordCounter[MAX_WORDS];

    public int getNumWords() {
        for(int i = 0; i < counters.length; i++) {
            if(counters[i] == null) {
                return i;
            } else if(i == counters.length - 1){
                return i+1;
            }
        }
        return 0;
    }
	
	/**
	 * Increment the count for the specified word.  Remember that this may
     * be the first time the word counter has seen this particular word.
	 * 
	 * @param word
	 */
	public void count(String word) {
        int n = getNumWords();
        for (int i = 0; i < n; i++) {
            if(counters[i].wordMatches(word)) {
                counters[i].incrementCount();
                return;
            }
        }
        counters[n] = new SingleWordCounter(word);
        counters[n].incrementCount();
	}
	
	/**
	 * Return the count for the particular word.  Remember that the
	 * word may not have been seen before.
	 * @param word
	 * @return
	 */
	public int getCount(String word) {
        for(int i = 0; i < getNumWords(); i++){
            if (counters[i].wordMatches(word)){
                return counters[i].getCount();
            }
        }
        return 0;
	}
	
	/**
	 * @return The an array of all words that have been counted
	 * (just the words, not the values).
	 */
	public String []  getAllWords() {
        int n = getNumWords();
        String words[] = new String[getNumWords()];
        for(int i =0; i < n; i++) {
            words[i] = counters[i].getWord();
        }
        return words;
	}
}

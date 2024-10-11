
import java.util.ArrayList;
import java.util.List;

/*
 
 Comes from the word reTRIEval
 used to retrieve information very fast
 by representing a single alphabet of a word

 */

public class Trie {
  private final TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public class TrieNode {
    TrieNode[] children;
    boolean isWord;
    List<String> suggestions; // Store possible suggestions at each node

    public TrieNode() {
      this.children = new TrieNode[26];
      this.isWord = false;
      suggestions = new ArrayList<>();
    }

  }

  public void insert(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      int index = c - 'a';

      if (current.children[index] == null) {
        TrieNode node = new TrieNode();
        current.children[index] = node;
        current = node;
      } else {
        current = current.children[index];
      }
      // Add the word to the suggestions at each level
      current.suggestions.add(word);
    }
    current.isWord = true;
  }

  public boolean search(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      int index = c - 'a';

      if (current.children[index] == null) {
        return false; // word not found
      }
    }
    return current.isWord;
  }

  // Get autocomplete suggestions for a prefix
  public List<String> getSuggestions(String prefix) {
    TrieNode currentNode = root;
    for (int i = 0; i < prefix.length(); i++) {
      int index = prefix.charAt(i) - 'a';
      if (currentNode.children[index] == null) {
        return new ArrayList<>(); // No suggestions if prefix not found
      }
      currentNode = currentNode.children[index];
    }
    return currentNode.suggestions; // Return stored suggestions for the prefix
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    // Inserting some popular searches
    trie.insert("javaprogramming");
    trie.insert("javadownload");
    trie.insert("javatutorial");
    trie.insert("javascript");
    System.out.println(trie.getSuggestions("java"));
  }

}

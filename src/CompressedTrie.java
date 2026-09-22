import java.util.*;

public class CompressedTrie {


    class Node {
        Map<Character, Node> children = new HashMap<>();
        List<Integer> productIds = new ArrayList<>();
    }

    private Node root = new Node();


    public void insert(String word, int productId) {

        word = word.toLowerCase();

        Node current = root;

        for (char ch : word.toCharArray()) {

            if (!current.children.containsKey(ch)) {
                current.children.put(ch, new Node());
            }

            current = current.children.get(ch);

            current.productIds.add(productId);
        }
    }


    public List<Integer> searchPrefix(String prefix) {

        prefix = prefix.toLowerCase();

        Node current = root;

        for (char ch : prefix.toCharArray()) {

            if (!current.children.containsKey(ch)) {
                return new ArrayList<>();
            }

            current = current.children.get(ch);
        }

        return current.productIds;
    }
}
public class HashNode {
    public String key;
    public String value;
    public HashNode next;
    
    // Constructs a single hash entry.
    public HashNode(String key, String value) {
        this(key, value, null);
    }

    // Constructs a single hash entry, with reference to the next hash entry.
    public HashNode(String key, String value, HashNode next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }    
}
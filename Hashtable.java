public class Hashtable {
	private static final int DEFAULT_SIZE = 200000;
    private HashNode[] table;
    private int size;
    
    
    public Hashtable() {
        this(DEFAULT_SIZE);
    }
    
    public Hashtable(int tableSize) {
        table = new HashNode[tableSize];
        size = 0;
    }
    
    
    public String get(String key) {
        int pos = hash(key);
        HashNode temp = table[pos];
        while(temp != null){
            if(temp.key == key){
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }
    
    public void put(String key, String value) {
        int keyBucket = hash(key);
        
        HashNode temp = table[keyBucket];
        while (temp != null) {
            if ((temp.key == null && key == null) 
                    || (temp.key != null && temp.key.equals(key))) {
                temp.value = value;
                return;
            }
            temp = temp.next;
        }
        
        table[keyBucket] = new HashNode(key, value, table[keyBucket]);
        size++;
    }


    /**
     * Returns true if the map contains a mapping for the given key.
     */
    public boolean containsKey(String key) {
        int keyBucket = hash(key);
        
        HashNode temp = table[keyBucket];
        while (temp != null) {
            if ((temp.key == null && key == null) 
                    || (temp.key != null && temp.key.equals(key))) {
                return true;
            }
            temp = temp.next;
        }
        
        return false;
    }

    public String remove(String key) {
        int pos = hash(key);
        HashNode temp = table[pos];
        if(temp == null){
            return null;
        }
        if(temp.key.equals(key)){
            table[pos] = temp.next;
            --size;
            return temp.value;
        }
        HashNode prev = temp;
        HashNode curr = prev.next;
        while(curr != null && ! curr.key.equals(key)){
            curr = curr.next;
            prev = curr;
        }
        if(curr != null){
            prev.next = curr.next;
            size--;
            return curr.value;
        }  
        return null;  
    }
    
    private int hash(String key) {
        if (key == null) {
            return 0;
        } else {
            return Math.abs(key.hashCode() % this.table.length);
        }
    }
}
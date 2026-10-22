package HashMap;

public class Nodes<K,V> {
    K key;
    V value;
    Nodes<K,V> next;
    public Nodes(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

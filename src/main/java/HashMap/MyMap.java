package HashMap;

import java.util.ArrayList;
import java.util.List;

public class MyMap<K,V> {

    private List<Nodes<K,V>> bucket;
    private int capacity; //length of the bucket
    private int size; //number of elements in the map
    private final int INITIAL_CAPACITY=5;//initial length of the bucket
    public MyMap() {
        bucket = new ArrayList<>();
        capacity = INITIAL_CAPACITY;
        for(int i =0;i<capacity;i++){
            bucket.add(null);
        }
    }

    public V get(K key){
        int bucketIndex=getBucketIndex(key);
        Nodes<K,V> node = bucket.get(bucketIndex);
        while(node != null){
            if(node.key.equals(key)){
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    private int getBucketIndex(K key) {
        int hash=key.hashCode();
        return hash%capacity;
    }

    public void put(K key, V value){
        int bucketIndex=getBucketIndex(key);
        Nodes<K,V> head = bucket.get(bucketIndex);
        Nodes<K,V> node = bucket.get(bucketIndex);
        while(node!=null){
            if(node.key.equals(key)){
                node.value = value;
                return;
            }
            node = node.next;
        }
        Nodes<K,V> newNode=new Nodes<K,V>(key,value);
        newNode.next=head;
        bucket.set(bucketIndex,newNode);
        double loadFactor = (1.0 * size) / capacity;
        System.out.println("inserting key " + key);
        System.out.println("Load Factor : " + loadFactor);
        if(loadFactor > 0.7)
            rehash();


    }

    private void rehash() {
        System.out.println("Rehashing buckets");
        List<Nodes<K , V>> temp = bucket;
        bucket = new ArrayList<>();
        capacity *= 2;
        for(int i = 0 ; i < capacity ; i ++)
            bucket.add(null);
        size = 0;

        for(int i = 0 ; i < temp.size() ; i ++) {
            Nodes<K , V> head = temp.get(i);
            while(head != null) {
                put(head.key , head.value);
                head = head.next;
            }
        }
    }

    public void remove(K key){
        int bucketIndex=getBucketIndex(key);
        Nodes<K,V>head = bucket.get(bucketIndex);
        Nodes<K,V> prev=null;
        while(head!=null){
            if(head.key.equals(key)){
                if(prev==null){
                    bucket.set(bucketIndex,head.next);
                }else{
                    prev.next=head.next;
                }
                head.next=null;
                size--;
                break;
            }
            prev=head;
            head=head.next;
        }


    }

}

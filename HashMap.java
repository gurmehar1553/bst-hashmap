import java.util.ArrayList;
import java.util.List;

public class HashMap {
    public static void main(String[] args) {
        String str = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
        String[] arr = str.toLowerCase().split(" ");
        HashMapImplement<String,Integer> mp = new HashMapImplement<>();
        for(String s:arr){
            MyMapNode<String, Integer> freq = mp.get(s);
            if(freq == null){
                mp.put(s,1);
            }
            else {
                mp.put(s,freq.val+1);
            }
        }
        System.out.print("Frequency of word 'paranoid' : ");
        System.out.println(mp.get("paranoid").val);
        System.out.println("Freq of each word: ");
        mp.print();
        mp.remove("avoidable");
        System.out.println(mp.get("avoidable"));
    }

}

class MyMapNode<K, V>{
    K key;
    V val;
    MyMapNode<K,V> next;
    MyMapNode(K key,V val){
        this.key = key;
        this.val = val;
    }
}

class HashMapImplement<K,V>{
    ArrayList<MyLinkedMap<K,V>> arr;
    int numBuckets;
    HashMapImplement(){
        this.numBuckets = 10;
        arr = new ArrayList<>(this.numBuckets);
        for (int i=0;i<this.numBuckets;i++){
            arr.add(null);
        }
    }
    public int hashFunction(K key){
        return Math.abs(key.hashCode() % this.numBuckets);
    }
    public MyMapNode<K,V> get(K key){
        int hash = hashFunction(key);
        MyLinkedMap<K,V> mp= arr.get(hash);
        if(mp == null){
            return null;
        }
        return mp.search(key);
    }
    public void put(K key,V val){
        int hash = hashFunction(key);
        MyLinkedMap<K,V> mp= arr.get(hash);
        if (mp == null){
            mp = new MyLinkedMap<>();
        }
        if (get(key) == null){
            mp.put(key,val);
        }
        else {
            mp.update(key,val);
        }
        arr.set(hash,mp);
    }
    public void remove(K key){
        int hash = hashFunction(key);
        MyLinkedMap<K,V> linkedMap = arr.get(hash);
        linkedMap.remove(key);
        arr.set(hash,linkedMap);
    }
    public void print(){
        for(MyLinkedMap<K,V> node: arr){
            if (node == null){
                continue;
            }
            node.print();
        }
    }
}

class MyLinkedMap<K,V>{
    MyMapNode<K,V> head, tail;
    MyLinkedMap(){
        head = null;
        tail = null;
    }
    public MyMapNode<K, V> get(K key){
        return search(key);
    }
    public MyMapNode<K,V> search(K key){
        MyMapNode<K,V> ptr = head;
        while (ptr != null && !ptr.key.equals(key)){
            ptr = ptr.next;
        }
        return ptr;
    }
    public void update(K key,V val){
        MyMapNode<K,V> nodeToUpdate = search(key);
        nodeToUpdate.val = val;
    }
    public void put(K key, V val){
        MyMapNode<K,V> newNode = new MyMapNode<>(key,val);
        if (head==null && tail == null){
            head = newNode;
            tail = head;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    public void remove(K key){
        MyMapNode<K,V> ptr = head;
        if (ptr.key == key){
            head = ptr.next;
            return;
        }
        while (ptr.next != null && !ptr.next.key.equals(key)){
            ptr = ptr.next;
        }
        if (ptr.next == null){
            return;
        }
        ptr.next = ptr.next.next;
    }
    public void print(){
        MyMapNode<K,V> ptr = head;
        if (ptr == null){
            System.out.println("Empty map");
            return;
        }
        while (ptr != null){
            System.out.print(ptr.key+" : "+ptr.val+" , ");
            ptr = ptr.next;
        }
        System.out.println();
    }
}
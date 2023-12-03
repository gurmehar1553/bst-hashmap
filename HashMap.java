import java.util.List;

public class HashMap {
    public static void main(String[] args) {
        String str = "To be or not to be";
        String[] arr = str.split(" ");
        MyHashMap<String,Integer> mp = new MyHashMap<>();
        for(String s:arr){
            int freq = mp.get(s);
            mp.put(s,freq+1);
        }

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

class MyHashMap<K,V>{
    MyMapNode<K,V> head, tail;
    MyHashMap(){
        head = null;
        tail = null;
    }
    public V get(K key){
        MyMapNode<K,V> node = search(key);
        if(node == null){
            return (V) Integer.valueOf(0);
        }
        return node.val;
    }
    public MyMapNode<K,V> search(K key){
        MyMapNode<K,V> ptr = head;
        if (ptr == null){
            return null;
        }
        while (ptr.next != null && ptr.next.key != key){
            ptr = ptr.next;
        }
        return ptr;
    }
    public void put(K key, V val){
        MyMapNode<K,V> newNode = new MyMapNode<>(key,val);
        if (tail == null){
            head = newNode;
            tail = head;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }
}
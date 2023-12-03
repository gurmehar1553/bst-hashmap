import java.util.List;

public class HashMap {
    public static void main(String[] args) {
        String str = "To be or not to be";
        String[] arr = str.toLowerCase().split(" ");
        MyHashMap<String,Integer> mp = new MyHashMap<>();
        for(String s:arr){
            int freq = mp.get(s);
            if(freq == 0){
                mp.put(s,freq+1);
            }
            else {
                mp.update(s,freq+1);
            }
        }
        mp.print();
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
        if(ptr.key == key){
            return ptr;
        }
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
        if (tail == null){
            head = newNode;
            tail = head;
            System.out.println("No elements");
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    public void print(){
        MyMapNode<K,V> ptr = head;
        while (ptr != null){
            System.out.println(ptr.key+" : "+ptr.val);
            ptr = ptr.next;
        }
    }
}
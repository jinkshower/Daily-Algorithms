package datastructure.hashtable;

public class MyHashTable {

    private Object[] data;

    public MyHashTable(int size) {
        this.data = new Object[size];

    }

    public void set(String key, Object value) {
        int hash = hash(key);
        data[hash] = value;
    }

    public Object get(String key) {
        int hash = hash(key);
        return data[hash];
    }

    private int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash + key.charAt(i) * i) % this.data.length;
        }
        return hash;
    }

    public static void main(String[] args) {
        MyHashTable myHashTable = new MyHashTable(50);
        myHashTable.set("grapes", 1000);
        Object object = myHashTable.get("grapes");
        System.out.println(object);
    }
}

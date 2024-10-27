package datastructure.self;

import java.util.Arrays;

public class MyHashMapArray {
    int[] data;

    public MyHashMapArray() {
        data = new int[100001];
        Arrays.fill(data, -1);
    }

    public void put(int key, int val) {
        data[key] = val;
    }

    public int get(int key) {
        return data[key];
    }

    public void remove(int key) {
        data[key] = -1;
    }
}

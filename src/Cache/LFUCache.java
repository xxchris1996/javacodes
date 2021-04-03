package Cache;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
    HashMap<Integer, Integer> keyToVal;
    HashMap<Integer, Integer> keyToFreq;
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    int minFreq;
    int cap;

    public LFUCache(int capacity){
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.cap = capacity;
        this.minFreq = 0;
    }

    public int get(int key){
        if(!keyToVal.containsKey(key)){
            return -1;
        }
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int val){
        if(this.cap <= 0) return;

        if(keyToVal.containsKey(key)){
            keyToVal.put(key,val);
            increaseFreq(key);
            return;
        }
        if(this.cap <= keyToVal.size()){
            removeMinFreqKey();
        }
        keyToVal.put(key,val);
        keyToFreq.put(key,1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        this.minFreq = 1;
    }

    public void removeMinFreqKey(){
        LinkedHashSet<Integer> keylist = freqToKeys.get(this.minFreq);
        int deleteKey = keylist.iterator().next();
        keylist.remove(deleteKey);
        if(keylist.isEmpty()){
            freqToKeys.remove(this.minFreq);
        }
        keyToFreq.remove(deleteKey);
        keyToVal.remove(deleteKey);
    }

    private void increaseFreq(int key){
        int freq = keyToFreq.get(key);
        keyToFreq.put(key,freq+1);
        freqToKeys.get(freq).remove(key);
        freqToKeys.putIfAbsent(freq+1, new LinkedHashSet<>());
        freqToKeys.get(freq+1).add(key);
        if(freqToKeys.get(freq).isEmpty()){
            freqToKeys.remove(freq);
            if(freq == this.minFreq){
                this.minFreq++;
            }
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1,10);
        cache.put(2,20);

        cache.get(1);

        cache.put(3,30);
        cache.get(2);
    }
}



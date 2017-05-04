import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCache {
    
    class Cache { // a class to remember frequency and recentness
        int key, f, r;
        public Cache(int k, int f, int r) {key=k;this.f=f;this.r=r;}
        // override equals() and hashCode()
        public boolean equals(Object object) {return key==((Cache) object).key;}
        public int hashCode() {return key;}
    }
    
    int capacity, id;
    HashMap<Integer, Integer> hashMap, frequency;
    PriorityQueue<Cache> queue;

    public LFUCache(int capacity) {
        this.capacity=capacity;
        id=0;
        hashMap=new HashMap<>();
        frequency=new HashMap<>();
        // sort by frequency and recentness
        queue =new PriorityQueue<>((o1,o2) -> o1.f==o2.f?o1.r-o2.r:o1.f-o2.f); 
    }
    
    public int get(int key) {
        id++;
        if (hashMap.containsKey(key)) {
            update(key);
            return hashMap.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (capacity==0) return;
        id++;
        if (hashMap.containsKey(key)) {
            update(key);
            hashMap.put(key, value);
            return;
        }
        if (hashMap.size()==capacity) {
            Cache first= queue.poll(); // find the smallest one, and remove it
            hashMap.remove(first.key);
            frequency.remove(first.key);
        }
        hashMap.put(key, value);
        frequency.put(key, 1);
        queue.add(new Cache(key, 1, id));
    }
    
    private void update(int key) { // update the priority queue
        int f=frequency.get(key);
        frequency.put(key, f+1); // get and update the frequency
        Cache cache=new Cache(key, f+1, id); // make a new Cache
        // remove the member in queue, if its key equals to the current key.
        // Here, queue uses `equals()` to judge the equality
        queue.remove(cache); 
        queue.add(cache); // add the current Cache to the queue.
    }


	public static void main(String[] args) {
		LFUCache cache = new LFUCache(3);

		// Key 1 : freq 1
		cache.put(1, 10);

		// Key 2 : freq 1
		cache.put(2, 20);
		
		// Key 1 : freq 2
		System.out.println(cache.get(1));
		
		// Key 3 : freq 1
		cache.put(3, 30);

		// Key 4 : freq 1
		cache.put(4, 40);

		// Now one of the LFU element should get removed which is 2. Let's see
		System.out.println(cache.get(2));

	}

}

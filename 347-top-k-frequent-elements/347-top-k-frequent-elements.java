class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0)+1);
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->(Integer.compare(freqMap.get(a), freqMap.get(b))));
        
        for (int key : freqMap.keySet()) {
            minHeap.add(key);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        
        int[] response = new int[k];
        int counter=0;
        while(!minHeap.isEmpty()) {
            response[counter++] = minHeap.poll();
        }
        
        return response;
    }
}
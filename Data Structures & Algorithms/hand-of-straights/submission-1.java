class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;

        // minHeap
        // 1 2 2 3 3 4 4 5
        // if start == next, use that
        // if start < next < start + groupSize

        TreeMap<Integer, Integer> count = new TreeMap<>();

        for (int num : hand) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        while (!count.isEmpty()) {
            int start = count.firstKey();
            for (int i = start; i < start + groupSize; i++) {
                if (count.getOrDefault(i, 0) < 1) return false;
                count.put(i, count.get(i) - 1);
                if (count.get(i) == 0) count.remove(i);
            }
        }

        return true;
    }
}

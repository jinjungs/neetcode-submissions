class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0;
        int r = people.length - 1;

        int boats = 0;
        while (l < r) {
            int weight = people[l] + people[r];
            if (weight <= limit) {
                boats++;
                l++;
                r--;
            } else {
                boats++;
                r--;
            }
        }

        if (l == r) boats++;

        return boats;
    }
}
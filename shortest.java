// Time Complexity : O(NlogN)
// Space Complexity : O()
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class ShortestWayToFormString {
    public int shortestWay(String source, String target) {
        HashMap<Character, List<Integer>> map = new HashMap<>();

        int m = target.length();
        int n = source.length();

        for (int i = 0; i < n; i++) {
            char schar = source.charAt(i);
            if (!map.containsKey(schar)) {
                map.put(schar, new ArrayList<>());
            }
            map.get(schar).add(i);
        }

        int i = 0; 
        int j = 0; 
        int count = 1;
        while (j < m) {
            char tchar = target.charAt(j);
            if (!map.containsKey(tchar)) // if the character is not present in source, return -1
                return -1;

            List<Integer> list = map.get(tchar);
            int k = binarySearchOnIndexList(list, i); 
            if (k == list.size()) { 
                count++;
                i = list.get(0);
            } else {
                i = list.get(k);

            }
            i++;

            j++;
        }
        return count;
    }

    private int binarySearchOnIndexList(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // to avoid integer overflow
            if (list.get(mid) == target) {
                return mid;
            } else if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
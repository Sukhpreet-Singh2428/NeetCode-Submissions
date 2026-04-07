class Pair {
    int key;
    int value;

    Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        ArrayList<Integer> ans = new ArrayList<>();

        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }

        ArrayList<Pair> v = new ArrayList<>();
        for (int key : mpp.keySet()) {
            v.add(new Pair(key, mpp.get(key)));
        }

        Collections.sort(v, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return b.value - a.value;
            }
        });

        for (int i = 0; i < k && i < v.size(); i++) {
            ans.add(v.get(i).key);
        }

        int[] arr = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            arr[i] = ans.get(i);
        }
        return arr;
    }
}

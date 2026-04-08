class Solution {
    public void generate(int idx, int n, List<List<Integer>> ans, List<Integer> ls, int[] nums){
        if(idx==n){
            ans.add(new ArrayList<>(ls));
            return;
        }

        ls.add(nums[idx]);
        generate(idx+1, n, ans, ls, nums);
        ls.remove(ls.size()-1);
        generate(idx+1, n, ans, ls, nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        generate(0, nums.length, ans, ls, nums);
        return ans;
    }
}

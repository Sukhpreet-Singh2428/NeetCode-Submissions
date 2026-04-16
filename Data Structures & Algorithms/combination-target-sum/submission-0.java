class Solution {
    public static void func(int idx, int sum, List<List<Integer>> ans, List<Integer> ls, int target, int[] nums, int n){
        if(sum==target){
            ans.add(new ArrayList<>(ls));
            return;
        }
        if(idx==n){
            if(sum==target){
                ans.add(new ArrayList<>(ls));
            }
            return;
        }
        if(sum>target){
            return;
        }

        ls.add(nums[idx]);
        sum += nums[idx];
        func(idx, sum, ans, ls, target, nums, n);
        ls.remove(ls.size()-1);
        sum -= nums[idx];
        func(idx+1, sum, ans, ls, target, nums, n);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        func(0, 0, ans, ls, target, nums, nums.length);
        return ans;
    }
}

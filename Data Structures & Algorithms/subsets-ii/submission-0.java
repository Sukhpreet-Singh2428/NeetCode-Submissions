class Solution {
    public int last(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                ans = mid;
                low = mid+1;
            }
            else if(nums[mid]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
    public void func(int idx, List<List<Integer>> ans, List<Integer> ls, int[] nums, int n){
        if(idx==n){
            ans.add(new ArrayList<>(ls));
            return;
        }

        ls.add(nums[idx]);
        func(idx+1, ans, ls, nums, n);
        ls.remove(ls.size()-1);
        int x = last(nums, nums[idx]);
        func(x+1, ans, ls, nums, n);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        func(0, ans, ls, nums, nums.length);
        return ans;
    }
}

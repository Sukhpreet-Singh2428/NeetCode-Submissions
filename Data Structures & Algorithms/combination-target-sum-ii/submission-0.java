class Solution {
    public int last(int[] arr, int target, int n){
        int low = 0;
        int high = n-1;
        int ans = n-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==target){
                ans = mid;
                low = mid+1;
            }
            else if(arr[mid] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
    public void func(int idx, int sum, int target, List<List<Integer>> ans, List<Integer> ls, int[] arr, int n){
        if(idx==n){
            if(sum==target){
                ans.add(new ArrayList<>(ls));
            }
            return;
        }
        if(sum==target){
            ans.add(new ArrayList<>(ls));
            return;
        }
        if(sum>target){
            return;
        }

        ls.add(arr[idx]);
        sum += arr[idx];
        func(idx+1, sum, target, ans, ls, arr, n);
        ls.remove(ls.size()-1);
        sum -= arr[idx];
        int x = last(arr, arr[idx], n);
        func(x+1, sum, target, ans, ls, arr, n);
    }
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        func(0, 0, target, ans, ls, arr, arr.length);
        return ans;
    }
}

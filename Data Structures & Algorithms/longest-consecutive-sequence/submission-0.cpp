class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> st(nums.begin(), nums.end());
        int cnt = 0;
        for(int i=0; i<nums.size(); i++){
            if(st.find(nums[i]-1) == st.end()){
                int k = 0;
                while(st.find(nums[i] + k) != st.end()){
                    k++;
                }
                cnt = max(cnt, k);
            }
        }
        return cnt;
    }
};

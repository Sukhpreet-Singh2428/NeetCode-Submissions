class Solution {
    public void generate(int idx, int open, int close, String s, List<String> ls, int n){
        if(idx == 2*n){
            if(open==close) ls.add(s);
            return;
        }
        if(close > open){
            return;
        }

        generate(idx+1, open+1, close, s+"(", ls, n);
        generate(idx+1, open, close+1, s+")", ls, n);
    }
    public List<String> generateParenthesis(int n) {
        List<String> ls = new ArrayList<>();
        generate(0, 0, 0, "", ls, n);
        return ls;
    }
}

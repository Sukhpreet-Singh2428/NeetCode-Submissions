class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<tokens.length; i++){
            String s = tokens[i];
            if(!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")){
                st.push(Integer.parseInt(s));
            }
            else{
                int a = st.pop();
                int b = st.pop();
                int res = 0;
                switch(s){
                    case "+" : res = b+a; break;
                    case "-" : res = b-a; break;
                    case "*" : res = b*a; break;
                    case "/" : res = b/a; break;
                }

                st.push(res);
            }
        }

        return st.pop();
    }
}

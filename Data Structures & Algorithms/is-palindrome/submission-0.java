class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            char f = s.charAt(i);
            char l = s.charAt(j);
            if(!((f >= 'a' && f <= 'z') || (f >= 'A' && f <= 'Z') || (f >= '0' && f <= '9'))) {
                i++;
            }
            else if(!((l >= 'a' && l <= 'z') || (l>= 'A' && l <= 'Z') || (l >= '0' && l <= '9'))) {
                j--;
            }
            else{
                f =  Character.toLowerCase(f);
                l =  Character.toLowerCase(l);
                if(f != l){
                    return false;
                }
                i++;
                j--;
            }
        }

        return true;
    }
}

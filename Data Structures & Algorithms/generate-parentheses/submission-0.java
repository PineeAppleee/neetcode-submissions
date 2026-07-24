class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> str = new ArrayList<>();
        rec(n,str,new StringBuilder(),0,0);
        return str;
    }

    public void rec(int n,List<String> str,StringBuilder s,int open,int close){

            if(s.length()==2*n){
            str.add(s.toString());
            return;}

        if(open<n){
            s.append("(");
            rec(n,str,s,open+1,close);
            s.deleteCharAt(s.length()-1);
        }

        if(close<open){
            s.append(")");
            rec(n,str,s,open,close+1);
            s.deleteCharAt(s.length()-1);
        }
       
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list=new LinkedList<>();
        search("(",1,0,list,n);
        return list;
        
    }
    void search(String curr,int a,int b, List<String> list,int n){
        if(curr.length()==2*n){
            list.add(curr);
            return;
        }
        if(a<n) search(curr+"(",a+1,b,list,n);
        if(b<a) search(curr+")",a,b+1,list,n);
        
    }
}
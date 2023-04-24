class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> lr = new ArrayList<>();
        int sum=1;
        for(int i=1;i<=n;i++) {lr.add(i);sum*=i;}
        StringBuilder sb = new StringBuilder();
        while(lr.size()!=0&&n>0)
        {
            //succesively decreasing the factorials value
            sum/=n--;
            //a considered case when a new row of element is going to start fr.eg if n=4 and k=12 then it is sitting at the max of getting '2' at first place i.e. 2431 after 3s line will take place
            if(k%sum==0){sb.append(lr.remove(k/(sum)-1)); for(int i=lr.size()-1;i>=0;i--) sb.append(lr.get(i)); return sb.toString();}
           // removing the element based on how the get considered by k
            sb.append(lr.remove(k/(sum)));

            k=k%sum;
        }
        return sb.toString();
    }
}
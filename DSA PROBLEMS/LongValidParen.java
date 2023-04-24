class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        // HashMap to store the index of the last occurrence of a particular balance of parentheses
        HashMap<Integer, Integer> map = new HashMap<>();
        // sum variable to keep track of the balance of parentheses encountered so far
        int sum = 0;
        // initialize the HashMap with an initial sum of 0 and index of -1
        map.put(0, -1);
        // variable to store the length of the longest valid parentheses substring
        int ans = 0;
        // traverse the input string
        for(int i = 0;i < n;i++){
            // if the current character is an opening parenthesis
            if(s.charAt(i) == '('){
                // increment the sum variable
                sum++;
                // if the current sum is already present in the HashMap and its value is 0, it means we have found a valid substring
                if(map.containsKey(sum) && sum == 0){
                    // calculate the length of the valid substring and update the ans variable if it is greater than the current value
                    ans = Math.max(i - map.get(sum), ans);
                }
                // add the current sum and its index to the HashMap if it is not already present
                else map.put(sum, i);
            }
            // if the current character is a closing parenthesis
            else{
                // decrement the sum variable
                sum--;
                // if the current sum is -1, it means we have encountered more closing parentheses than opening parentheses so far
                if(sum == -1){
                    // reset the HashMap and sum variable and add the current index with sum 0 to the HashMap
                    map.clear();
                    map.put(0, i);
                    sum = 0;
                }
                // if the current sum is present in the HashMap, we have found a valid substring
                else{
                    // calculate the length of the valid substring and update the ans variable if it is greater than the current value
                    if(map.containsKey(sum)){
                        ans = Math.max(i - map.get(sum), ans);
                    }
                    // add the current sum and its index to the HashMap if it is not already present, with index + 1 since the current index is for the closing parenthesis
                    else map.put(sum, i+1);
                }
            }
        }
        // return the length of the longest valid parentheses substring
        return ans;
        
    }
}
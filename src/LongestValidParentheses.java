public class LongestValidParentheses {
  public static int longestValidParentheses(String str) {
    int left = 0;
    int right = 0;
    int maxLen = 0;

    //left to right scan for closing parentheses
    for(int i=0; i<str.length(); i++) {
      if(str.charAt(i) == '(') left++;
      else right++;
      if(left==right) maxLen = Math.max(maxLen, 2*left);
      else if(right>left) {
        left = 0;
        right = 0;
      }
    }
    left = 0;
    right = 0;

  //right to left scan for opening parentheses
  for(int i=str.length()-1; i>=0; i--) {
    if(str.charAt(i)=='(') left++;
    else right++;
    if(left==right) maxLen = Math.max(maxLen, 2*right);
    else if(left>right){
      left=0;
      right=0;
    }
  }
    return maxLen;
}

public static void main(String[] args) {
  String[] testCasesArray = {"", "()", ")()())", "(()", "()(())"};
  for(String tc : testCasesArray) {
    System.out.println("test: " + longestValidParentheses(tc));
  }
}
}
    

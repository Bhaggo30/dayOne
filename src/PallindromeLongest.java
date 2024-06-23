public class PallindromeLongest {


        public static boolean isPallindrome(String st) {
            int i = 0;
            while(i<st.length()/2){
                if(st.charAt(i)!=st.charAt(st.length()-1-i))
                    return false;
                i++;
            }
            return true;
        }
        public static String longPallindrome(String s) {
            int start =0;
            int end =0;
            for (int i =0; i<s.length();i++){
                int odd = expand(s,i,i);
                int even = expand(s,i,i+1);

                int length = Math.max(odd,even);
                if (length > end-start){
                    start = i-(length-1)/2;
                    end = i+length/2;
                }
            }
            return s.substring(start,end+1);
        }
        public  static  int expand(String s ,int left,int right){
            while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            return right-left-1;
        }
        public static void main(String[] args) {
            String st = "babad";
            String str="";
            System.out.println("longest pallindrome substring are :-"+longPallindrome(st));
        }
    }






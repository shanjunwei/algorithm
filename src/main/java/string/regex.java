package string;

public class regex {


    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) return false;

        if (str.length == 0 && str.length == pattern.length) return true;

        if (String.valueOf(pattern).equals(".*")) return true;
        // 贪婪匹配
        int i = 0, j = 0;
        boolean flag = (i < str.length && j < pattern.length);
        while (flag){
            while (pattern[i] == str[j] && flag) {
                i++;
                j++;
            }
        }
//        while (board) {
//            while (pattern[i] == str[j] && board) {
//                i--;
//                j--;
//            }
//            while (pattern[i] == '.' && board) {
//                i--;
//                j--;
//            }
//            if (pattern[i] == '*' && board) {
//                while (pattern[i] != str[j] && board) {
//                    i--;
//                }
//            }
//
//            if (i == 0 && j == 0) return true;
//            else  return false;
//        }


        return false;
    }


    public static void main(String[] args) {
        regex regex = new regex();


        boolean flag = regex.match("abcdefga".toCharArray(), "a.*a".toCharArray());
        System.out.println(flag);

    }


}

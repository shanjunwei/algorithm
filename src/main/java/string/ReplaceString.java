package string;

public class ReplaceString {

    public static String replaceSpace(StringBuffer str) {
        char[] array = str.toString().toCharArray();
        str.delete(0,str.length());
        int i =0;
        while(i<=array.length-1){
            while (i<array.length && array[i]!=' '){
                str.append(array[i]);
                i++;
            }
            int flag = 0;
            while (i<array.length && array[i]==' '){
                flag++;
                i++;
            }
            for (int j = 0; j < flag; j++) {
                str.append("%20");
            }
        }
        return str.toString();
    }


    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("WeHappy");
        System.out.println(replaceSpace(str));

    }
}

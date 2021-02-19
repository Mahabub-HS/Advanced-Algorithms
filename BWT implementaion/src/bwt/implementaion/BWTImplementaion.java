package bwt.implementaion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Joniyed
 */
public class BWTImplementaion {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = "panamabanana";
        str = BWT(str);
        System.out.println("BWT transform is : "+str);

        str = inversBWT(str);
        System.out.println("original form is : "+str);
    }

    private static String BWT(String str) {
        str += "$";
        String[] arr = new String[str.length()];
        arr[0] = str;
        for (int i = 1; i < str.length(); i++) {
            String temp = str.charAt(str.length() - 1) + str.substring(0, str.length() - 1);
            arr[i] = temp;
            str = temp;
        }

        Arrays.sort(arr);
        str = "";
        for (String arr1 : arr) {
            str += arr1.charAt(arr1.length() - 1);
        }

        return str;
    }

    private static String inversBWT(String str) {

        String sorted
                = Stream
                        .of(str.split(""))
                        .sorted()
                        .collect(Collectors.joining());

        String res = "";

        String[] sortedArray = new String[str.length()];
        String[] mainArray = new String[str.length()];
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map1 = new HashMap<>();
          
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                mainArray[i] = str.charAt(i) + "" + 1;
                map.put(str.charAt(i), 1);
            } else {
                int a = map.get(str.charAt(i));
                a++;
                mainArray[i] = str.charAt(i) + "" + a;
                map.put(str.charAt(i), a);
            }
            
             if(!map1.containsKey(sorted.charAt(i))){
                sortedArray[i]=sorted.charAt(i)+""+1;
                map1.put(sorted.charAt(i),1);
            }else{
                int b = map1.get(sorted.charAt(i));
                b++;
                sortedArray[i]=sorted.charAt(i)+""+b;
                map1.put(sorted.charAt(i), b);
            }
        }
        
        
        String s=mainArray[0];
        
        for (String mainArray1 : mainArray) {
            res+=s.charAt(0);
            for(int j=1;j<sortedArray.length;j++){
                if(sortedArray[j].equals(s)){
                    s=mainArray[j];
                    sortedArray[j]="$";
                    break;
                }
            }
        }
        
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(res);
        res = stringBuilder.reverse().toString();
        return res;
    }

}

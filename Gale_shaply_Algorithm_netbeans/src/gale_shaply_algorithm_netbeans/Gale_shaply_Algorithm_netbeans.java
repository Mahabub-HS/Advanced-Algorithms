package gale_shaply_algorithm_netbeans;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Joniyed
 */
public class Gale_shaply_Algorithm_netbeans {

    static final int n = 5;

    private static void stableCouple(int[][] prefer) {

        int[] wPartner = new int[n];
        int[] freeMan = new int[n];

        Arrays.fill(freeMan, 0);
        Arrays.fill(wPartner, -1);

        int totalFreeManAvailable = n;

        while (totalFreeManAvailable > 0) {
            int j;
            for (j = 0; j < n; j++) {
                if (freeMan[j] == 0) {
                    break;
                }
            }

            for (int i = 0; i < n && freeMan[j] == 0; i++) {
                int w = prefer[j][i];
                if (wPartner[w - n] == -1) {
                    wPartner[w - n] = j;
                    freeMan[j] = 1;
                    totalFreeManAvailable--;
                } else {
                    int cur = wPartner[w - n];
                    if (bestOne(prefer, w, j, cur)) {
                        wPartner[w - n] = j;
                        freeMan[j] = 1;
                        freeMan[cur] = 0;
                    }
                }
            }
        }

        Map<Character,Character> res = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char a =(char) ((char)wPartner[i]+65);
            char b =(char) ((char)i+n+71);
            res.put(a, b);
        }
        
        
        System.out.println("M-W");
        
        res.forEach((key,value) -> {
            System.out.println(key+"("+((int)key-65)+")-"+value+"("+((int)value-71+")"));
        });

    }

    public static void main(String[] args) {
        int[][] prefer = {
            {8, 6, 7, 5, 9},
            {9, 7, 6, 5, 8},
            {6, 9, 5, 8, 7},
            {9, 6, 8, 7, 5},
            {8, 5, 6, 7, 9},
            {3, 1, 4, 2, 0},
            {1, 0, 3, 2, 4},
            {0, 2, 4, 3, 1},
            {3, 0, 2, 1, 4},
            {1, 4, 0, 2, 3}
        };

/*        int [][]prefer = { {7, 5, 6, 4},
{5, 4, 6, 7},
{4, 5, 6, 7},
{4, 5, 6, 7},
{0, 1, 2, 3},
{0, 1, 2, 3},
{0, 1, 2, 3},
{0, 1, 2, 3},
};*/
        stableCouple(prefer);
    }

    private static boolean bestOne(int[][] prefer, int w, int j, int cur) {

        for (int i = 0; i < n; i++) {
            if (prefer[w][i] == j) {
                return true;
            }else if(prefer[w][i]==cur){
                return false;
            }
        }

        return false;
    }

}

package sub.set.sum.problem;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Joniyed
 */
public class SubSetSumProblem {
    
    public static void main(String[] args) {
        int [] set = {3,2,7,1};
        int sum = 6;
        
        findSubSet(set,sum);
    }

    private static void findSubSet(int[] set, int sum) {
        char [][] table = new char[set.length+1][sum+1];
        
        for(int i=0;i<=set.length;i++){
            for(int j=0;j<=sum;j++){
                if(i==0 && j!=0)table[i][j]='F';
                else if(j==0) table[i][j]='T';
                else if(set[i-1]>j)table[i][j]=table[i-1][j];
                else if(table[i-1][j]=='T' | table[i-1][Math.abs(j-set[i-1])]=='T')table[i][j]='T';
                else table[i][j]='F';
            }
        }
        
        List<Integer> subset = new ArrayList<>();
        
       
        int row=set.length,col=sum,s=sum;
        while(s!=0 && row!=0 | col!=0){
            if(table[row][col]=='T' && table[row-1][col]=='F'){
                if(!subset.contains(set[row-1])) subset.add(set[row-1]);
                col=col-set[row-1];
                s-=set[row-1];
            }else{
                row--;
            }
        }
        
        
        System.out.println("Sub set is"+subset);
        
        System.out.println("Table is");
        
        for(int i=0;i<=set.length;i++){
            for(int j=0;j<=sum;j++){
                System.out.print(table[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
}

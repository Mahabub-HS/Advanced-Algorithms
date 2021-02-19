package coinchangeproblem;
/**
 * @author Joniyed
 */
public class CoinChangeProblem{

    public static void main(String[] args) {
        int[] coins = {1,2,3,5};
        int N = 7;
            System.out.println("\nMaximum of "+coinChange(coins,N,coins.length)+" ways we can get "+N+"....");
    }
    private static int coinChange(int[] coins, int N, int s) {
        int[][] table = new int[s+1][N+1];

        for(int i=0;i<=s;i++){
            for(int j=0;j<=N;j++){
                if(i==0 && j==0) table[i][j]=1;
                else if(i==0 && j!=0) table[i][j]=0;
                else if(coins[i-1]>j) table[i][j]=table[i-1][j];
                else{
                    table[i][j]=table[i-1][j]+table[i][(int)(j-coins[i-1])];
                }
            }
        }
        PrintTheTable(table,s,N);
        return table[s][N];
    }

    private static void PrintTheTable(int[][] table,int row, int col) {
        System.out.println("Table is : ");
        for(int i=0;i<=row;i++){
            for(int j=0;j<=col;j++){
                System.out.print(table[i][j]+" ");
            }
            System.out.println();
        }
    }
}

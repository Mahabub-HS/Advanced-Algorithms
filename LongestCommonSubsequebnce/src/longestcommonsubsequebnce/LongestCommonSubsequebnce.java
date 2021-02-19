package longestcommonsubsequebnce;

/**
 *
 * @author Joniyed
 */
public class LongestCommonSubsequebnce {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] lengthArray = {1,2,3,4};
        int[] priceArray = {2,5,9,6};
        int N = 5;
        System.out.println(rodCutting(lengthArray,priceArray,N));
    }

    private static int rodCutting(int[] lengthArray, int[] priceArray, int N) {
        
        int[][] table = new int[lengthArray.length+1][N+1];
        
        for(int i=0;i<lengthArray.length+1;i++){
            for(int j=0;j<N+1;j++){
                if(i==0 || j==0){
                    table[i][j]=0;
                }
                else if(j<i){
                    table[i][j]=table[i-1][j];
                }
                else{
                    table[i][j]=Math.max(table[i-1][j], priceArray[i-1]+table[i][j-i]);
                }
            }
        }
        
        
        for(int i=0;i<=lengthArray.length;i++){
            for(int j=0;j<=N;j++){
                System.out.print(table[i][j]+" ");
            }
            System.out.println("");
        }
        
        
        
        return table[lengthArray.length][N];
    }
    
}

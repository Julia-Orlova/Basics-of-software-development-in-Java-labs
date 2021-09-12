/* C5 = 3; C7 = 6; C11 = 0
1) C = A XOR B
2) Calculate the sum of the smallest elements of each column of the matrix
Type - float
*/

package Lab2;

public class Lab2 {
    public static void main(String[] args) {
        float[][] A = {{-1, 2, 3, 1},
                {4, 5, 6, 2},
                {7, -8, 9, 3}};
        float[][] B = {{8, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        int arow = A.length;
        int acolumn = A[0].length;
        int brow = B.length;
        int bcolumn = B[0].length;

        float[][] C = new float[arow + brow][acolumn + bcolumn];

        for (int i = 0; i < (arow + brow); i++) {
            for (int j = 0; j < (acolumn + bcolumn); j++) {
                if (j < acolumn && i < arow) {
                    C[i][j] = A[i][j];
                }
                else if (j >= acolumn && i >= arow){
                    C[i][j] = B[i-arow][j- acolumn];
                }
                else {
                    C[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C[0].length; j++) {
                System.out.print(C[i][j]+"  ");
            }
            System.out.println();
        }

        float min;
        float S = 0;
        for (int j = 0; j < (bcolumn + acolumn); j++){
            min = C[0][j];
            for (int i = 0; i < (brow + arow); i++){
                if (C[i][j] < min){
                    min = C[i][j];
                }
            }
            S += min;
        }
        System.out.println("\nThe sum of the smallest elements of each column of the matrix: " + S);

    }
}
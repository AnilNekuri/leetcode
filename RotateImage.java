import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        RotateImage ri = new RotateImage();
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        ri.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
    public void rotate(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix.length];
        var l = matrix.length-1;
        for(int i=0; i <= l; i++){
            for(int j = 0; j <= l; j++){
                var ti = l-j;
                var tj = i;
                result[i][j] = matrix[ti][tj];
            }
        }
        for(int i = 0; i <= l; i++){
            matrix[i] = result[i];
        }
    }
}

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        //int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        List<Integer> result = matrixModifiedVersionWithBoundaries(matrix);
        System.out.println(result);
    }


    public static List<Integer> matrix(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;
        // while (result.size() < (matrix.length * matrix[0].length)) {
        while (left <= right && top <= bottom) {
            //traverse left to right
            if (left <= right && top <= bottom) {
                for (int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
            }
            //traverse top to bottom and since top row traverse completed
            top++;
            if (left <= right && top <= bottom) {
                for (int i = top; i <= bottom; i++) {
                    result.add(matrix[i][right]);
                }
            }
            //traverse right to left and extreme right column completed so reduce right
            right--;

            if (left <= right && top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
            }
            //traverse bottom to tom and extreme bottom completed so reduce bottom
            bottom--;
            if (left <= right && top <= bottom) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
            }
            //extreme left completed ,so move one step left to right
            left++;
        }

        return result;
    }

    //modified version

    public static List<Integer> matrixModifiedVersionWithBoundaries(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;
        // while (result.size() < (matrix.length * matrix[0].length)) {
        while (left <= right && top <= bottom) {
            //traverse left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            //traverse top to bottom and since top row traverse completed
            top++;
            //below condition is true when array like {{1,2,3,4}} ,here top 1 and bottom 0 failure scenario
            if (top > bottom) {
                break;
            }
            //if top > bottom false means more than one row exist,so we can traverse top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            //traverse right to left and extreme right column completed so reduce right
            right--;
            //below condition true when we have array like {{1},{2},{3}}
            if (left > right) {
                break;
            }
            //more than one row exist and  left > right failed means we have more than one columns
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            //traverse bottom to top and extreme bottom completed so reduce bottom
            bottom--;
            //below condition true when array like {{1,2,3,4},{5,6,7,8}}
            //top = 1 and bottom = 0
            if (top > bottom) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            //extreme left completed ,so move one step left to right
            left++;
        }

        return result;
    }
}

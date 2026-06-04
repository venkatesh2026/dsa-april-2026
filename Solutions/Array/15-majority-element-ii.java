import java.util.ArrayList;
import java.util.List;

public class MultipleMajorityElements {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{4, 4, 2, 3, 2, 2}));
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> elements = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return elements;
        }
        int candidate1 = nums[0];
        int candidate2 = nums[0];
        int count1 = 1;
        int count2 = 0;
        for (int i = 1; i < nums.length; i++) {
            if (count1 > 0 && candidate1 == nums[i]) {//4,3,2,4
                count1++;
            } else if (count2 > 0 && candidate2 == nums[i]) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (candidate1 == num) {
                count1++;
            } else if (candidate2 == num) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            elements.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            elements.add(candidate2);
        }
        return elements;
    }
}

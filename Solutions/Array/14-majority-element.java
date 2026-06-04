public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2, 4};
        System.out.println(majorityElement(nums));

    }

    public static int majorityElement(int[] nums) {
        int arrayLength = nums.length;
        if (arrayLength == 1) {
            return nums[0];
        }
        int majorityElement = nums[0];
        int count = 1;

        for (int i = 1; i < arrayLength; i++) {
            if (majorityElement == nums[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                majorityElement = nums[i];
                count = 1;
            }
        }

        int majorityElementAppearanceCount = 0;
        for (int element : nums) {
            if (majorityElement == element) {
                majorityElementAppearanceCount++;
            }
        }
        return majorityElementAppearanceCount > arrayLength / 2 ? majorityElement : -1;
    }
}

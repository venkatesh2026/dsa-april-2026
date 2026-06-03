import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 1, 2, 3, 1, 3, 2, 4};
        int k = 2;
        int[] result = topKFrequent(nums, k);
        System.out.println("result:"+Arrays.toString(result));

    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> elementFrequencyMap = new HashMap();
        for (int num : nums) {
            if (elementFrequencyMap.containsKey(num)) {
                elementFrequencyMap.put(num, elementFrequencyMap.get(num) + 1);
            } else {
                elementFrequencyMap.put(num, 1);
            }
        }
        System.out.println(elementFrequencyMap);
        Set<Map.Entry<Integer, Integer>> entries = elementFrequencyMap.entrySet();
        Map<Integer, List<Integer>> frequencyElementMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (frequencyElementMap.containsKey(entry.getValue())) {
                List<Integer> integers = frequencyElementMap.get(entry.getValue());
                integers.add(entry.getKey());
            } else {
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(entry.getKey());
                frequencyElementMap.put(entry.getValue(), integers);
            }
        }
        //now map frequencyElementMap contains frequency as key and appeared same number of time elements in list as value
        //{1,1,1,1,1} 1 appears 5 times
        //{1,2,3,4,5} each element 1 time
        //{1,2,1,3,4,1,2} 1 - 3(times),2 - 2(times),3-1(time),4-1(time)
        //for example from above array to get top 2 frequent elements run a for loop by n(size of array),from n to 1 since we need max appeared elements

        int count = 0;
        for (int i = nums.length; i >= 1; i--) {
            if (frequencyElementMap.containsKey(i)) {
                for (Integer num : frequencyElementMap.get(i)) {
                    result[count] = num;
                    count++;
                }
            }
            if (count == k) {
                break;
            }
        }
        return result;
    }
}
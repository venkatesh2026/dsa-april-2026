class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> result = new ArrayList<List<Integer>>();
        subSet(nums,0,new ArrayList<Integer>(),result);
        return result;
        
    }

    private void subSet(int[] nums,int index,List<Integer> list,List<List<Integer>> result) {
        if(index>=nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        list.add(nums[index]);
        subSet(nums,index+1,list,result);
        list.remove(list.size()-1);
        subSet(nums,index+1,list,result);
    }
}


/**
*给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
*输入：nums = [2,7,11,15], target = 9
*输出：[0,1]
*解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
*/

public int[] twoSum(int[] nums, int target) {
      int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++){
                if(nums[i]+nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }


/**
* 一种利用map的解法，时间复杂度更低
*/
public int[] twoSum(int[] nums, int target) {
      int[] indexs = new int[2];

    // 建立k-v ，一一对应的哈希表
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }
        return indexs;
    }

class Solution {
   public int search(int[] nums, int target) {
    int l = 0;
    int r = nums.length-1;
    while(l<=r){
        int mid = (l+r)>>1;
        if(nums[mid]==target){
            return mid;
        }
        if(nums[mid]> nums[r]){
            if(target > nums[mid] || nums[r]>= target)l = mid+1;
            else r = mid-1;
        }
        else{
            if(target <= nums[r] && target > nums[mid]) l = mid+1;
            else r = mid -1;
        }
    }
    return -1;
}
}

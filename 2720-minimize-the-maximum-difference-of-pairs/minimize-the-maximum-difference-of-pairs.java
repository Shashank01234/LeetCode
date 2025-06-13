class Solution {
  public int minimizeMax(int[] nums, int p) {
    Arrays.sort(nums);

    int l = 0;
    int r = nums[nums.length - 1] - nums[0];

    while (l < r) {
      final int m = (l + r) / 2;
      if (numPairs(nums, m) >= p)
        r = m;
      else
        l = m + 1;
    }

    return l;
  }

  // Returns the number of pairs that can be obtained if the difference between each
  // pair <= `maxDiff`.
  private int numPairs(int[] nums, int maxDiff) {
    int pairs = 0;
    for (int i = 1; i < nums.length; ++i)
      // Greedily pair nums[i] with nums[i - 1].
      if (nums[i] - nums[i - 1] <= maxDiff) {
        ++pairs;
        ++i;
      }
    return pairs;
  }
}
        // Arrays.sort(nums);
        // int len = nums.length;
        // int len1,len2;
        // if ((len-1)%2==0){
        //     len1 = (len-1)/2;
        //     len2 = (len-1)/2;
        // }

        // else{
        //     len1 = (len)/2;
        //     len2 = (len-2)/2;
        // }

        // int[] arr1 = new int[len1];
        // int[] arr2 = new int[len2];
        // int a=0, b=0;
        // for (int i=0; i<len-1; i++){
        //     if (i%2==0){
        //         arr1[a] = nums[i+1]-nums[i];
        //         a++;
        //     }
        //     else{
        //         arr2[b] = nums[i+1]-nums[i];
        //         b++;
        //     }    
        // }



        // Arrays.sort(arr1);
        // Arrays.sort(arr2);
        // if ((p-1)<0){
        //     return 0;
        // }

        // if (arr1.length>=p && arr2.length>=p){
        //     if (arr1[p-1]>arr2[p-1]){
        //         return arr2[p-1];
        //     }

        //     return arr1[p-1];
        // }

        // else if(arr1.length<p && arr2.length>=p){
        //     return arr2[p-1];
        // }

        // else if(arr1.length>=p && arr2.length<p){
        //     return arr1[p-1];
        // }

        // else{
        //     return 0;
        // }  
//     }
// }
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int high = arr.length-1;
        int low = 0;
        int l=0, r=0;

        List<Integer> res = new ArrayList<>();

        if(arr[low] > x){
            for(int i=0; i<k; i++){
                res.add(arr[i]);
            }

            return res;
        }

        if(arr[high] < x){
            for(int i=arr.length - k; i<arr.length; i++){
                res.add(arr[i]);
            }

            return res;
        }

        while(low <= high){
            int mid = low + (high-low)/2;

            if(arr[mid] == x){
                l = mid;
                break;
            }
            
            else if(arr[mid] > x){
                high = mid-1;

                if(arr[high] <= x){
                    l = high;
                    break;
                }
            }

            else{
                low = mid+1;

                if(arr[low] >= x){
                    l = mid;
                    break;
                }
            }
        }

        if(l == arr.length-1){
            l = arr.length - k;
            while(l < arr.length){
                res.add(arr[l++]);
            }

            return res;
        }

        r = l+1;
        int count = 0;

        while(l>=0 && r<arr.length && count<k){
            int left = x - arr[l];
            int right = arr[r] - x;

            if(left <= right){
                res.add(arr[l--]);
                count++;
            }

            else{
                res.add(arr[r++]);
                count++;
            }

            if(r>=arr.length && count<k){
                while(count!=k){
                    res.add(arr[l--]);
                    count++;
                }
            }

            if(l<0 && count<k){
                while(count!=k){
                    res.add(arr[r++]);
                    count++;
                }
            }
        }

        Collections.sort(res);
        return res;
    }
}
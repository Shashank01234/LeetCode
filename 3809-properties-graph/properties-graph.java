class Solution {
    private int[] group;
    private int gno = 1;
    public int numberOfComponents(int[][] properties, int k) {
        int n = properties.length;
        group = new int[n];
        boolean change = false;

        for(int i=0; i<n; i++) {
            if(group[i] == 0){
                group[i] = gno;
                gno++;
                change = true;
            }
            for(int j=i+1; j<n; j++) {
                if(group[i] == group[j]) {
                    continue;
                }

                if(intersect(properties[i], properties[j]) >= k) {
                    if(group[j] == 0) {
                        group[j] = group[i];
                    }
                    else if(group[j] > group[i]) {
                        changeGroup(j, i);
                    }
                    else{
                        group[i] = group[j];
                        if(change) {
                            gno--;
                        }
                    }
                }
            }

            change = false;
        }

        return gno-1;       
    }

    private int intersect(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        int count=0;

        for(int i=0; i<a.length; i++) {
            set.add(a[i]);
        }

        for(int i=0; i<b.length; i++) {
            if(set.contains(b[i])) {
                set.remove(b[i]);
                count++;
            }
        }

        return count;
    }

    private void changeGroup(int a, int b){
        int mVal = 0;
        for(int i=0; i<group.length; i++) {
            group[i] = group[i] == group[a] ? group[b]:group[i];

            mVal = Math.max(mVal, group[i]);
        }

        gno = mVal+1;
    }
}
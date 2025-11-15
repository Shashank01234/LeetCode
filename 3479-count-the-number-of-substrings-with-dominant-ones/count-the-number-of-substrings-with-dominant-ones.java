class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        ArrayList<Integer> posZero = new ArrayList<>();
        for (int i = 0; i < n; i++) if (s.charAt(i) == '0') posZero.add(i);

        int nZeros = posZero.size();
        long ans = 0L;

        if (nZeros == 0) {
            long L = n;
            return (int) (L * (L + 1)) / 2;
        } else {
            int prev = -1;
            for (int zpos : posZero) {
                int onesRun = zpos - prev - 1;
                if (onesRun > 0) ans += (long) onesRun * (onesRun + 1) / 2;
                prev = zpos;
            }
            int lastRun = n - 1 - posZero.get(nZeros - 1);
            if (lastRun > 0) ans += (long) lastRun * (lastRun + 1) / 2;
        }

        int B = (int) Math.sqrt(n);

        for (int z = 1; z <= B; z++) {
            long Lmin = 1L * z * z + z; 

            if (z > nZeros) break;

            for (int i = 0; i + z - 1 < nZeros; i++) {
                int leftZeroIdx = posZero.get(i);
                int rightZeroIdx = posZero.get(i + z - 1);

                int prevZeroPos = (i == 0) ? -1 : posZero.get(i - 1);
                int leftChoices = leftZeroIdx - prevZeroPos; 

                int nextZeroPos = (i + z == nZeros) ? n : posZero.get(i + z);
                int rightChoices = nextZeroPos - rightZeroIdx; 

                long baseLen = (rightZeroIdx - leftZeroIdx + 1); 
                long need = Lmin - baseLen; 

                long A = leftChoices;
                long Bc = rightChoices;
                long totalPairs = A * Bc;

                if (need <= 0) {
                    ans += totalPairs;
                    continue;
                }

                if (need > (A - 1) + (Bc - 1)) {
                    continue;
                }

                long T = need;
                long k = Math.min(A, T);
                if (k <= 0) {
                    ans += totalPairs;
                    continue;
                }

                long a1 = Math.max(0L, T - Bc);
                if (a1 > k) a1 = k; 

                long pairsSumLess = 0L;
                pairsSumLess += a1 * Bc;

                long cntPart2 = k - a1; 
                if (cntPart2 > 0) {
                    long sumA = (a1 + (k - 1)) * cntPart2 / 2; 
                    pairsSumLess += cntPart2 * T - sumA;
                }

                long valid = totalPairs - pairsSumLess;
                ans += valid;
            }
        }

        return (int) ans;
    }
}
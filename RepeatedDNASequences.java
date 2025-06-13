// Time complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();

        HashSet<Long> allSeq = new HashSet<>();
        HashSet<String> result = new HashSet<>();

        long hash = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('C', 2);
        map.put('G', 3);
        map.put('T', 4);

        long posFac = (long)Math.pow(4, 10);

        for(int i = 0; i < n; i++) {
            char in = s.charAt(i);
            hash = hash * 4 + map.get(in);

            if(i >= 10) {
                char out = s.charAt(i - 10);
                hash = hash - (posFac * map.get(out));
            }

            if(i >= 9) {
                if(allSeq.contains(hash)) {
                    result.add(s.substring(i - 9, i + 1));
                } else {
                    allSeq.add(hash);
                }
            }
        }

        return new ArrayList<>(result);
    }
}

class Solution {

    public String encode(List<String> strs) {
        // 12#
        StringBuilder sb = new StringBuilder();
        for (String str: strs){
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int n = str.length();
        while(i < n) {
            int start = i;
            while (i < n && str.charAt(i) != '#') {
                i++;
            }
            int len = Integer.parseInt(str.substring(start, i));
            res.add(str.substring(i+1, i+len+1));
            i += (len + 1);
        }

        return res;
    }
}

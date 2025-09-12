class Solution {
    public int solution(int[] ingredient) {
        
        StringBuilder str = new StringBuilder();
        for (int n : ingredient) str.append(n);

        int result = 0;
        int index;

        while ((index = str.indexOf("1231")) >= 0) {
            result++;
            str.delete(index, index+4);
        }

        return result;
    }
}
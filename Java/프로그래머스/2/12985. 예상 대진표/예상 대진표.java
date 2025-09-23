class Solution
{
    public int solution(int n, int a, int b)
    {
        a -= 1;
        b -= 1;
        int answer = 0;
        
        while (a != b) {
            a >>= 1;
            b >>= 1;
            answer++;
        }

        return answer;
    }
}
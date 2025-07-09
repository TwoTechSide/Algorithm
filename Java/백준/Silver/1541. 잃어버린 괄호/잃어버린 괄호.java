import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder expression = new StringBuilder();

        expression.append(br.readLine());   // 수식 입력
        int sign = 1;                       // 첫 시작은 '+'라고 가정
        int result = 0;

        // 첫 시작이 -가 아닌 경우 '+' 문자 추가
        if (expression.charAt(0) != '-')
            expression.insert(0, '+');

        while (true) {
            if (expression.charAt(0) == '-') sign = -1;   // '-'가 나올 때부터 음수로 누적
            expression.deleteCharAt(0);             // 첫 부등호 제거

            // 다음 부호 위치 찾기
            int signPlus = expression.indexOf("+");
            int signMinus = expression.indexOf("-");

            // 만약 다음 부호가 없을 경우, 남아있는 값을 저장하며 반복문 종료
            if (signPlus == -1 && signMinus == -1) {
                result += sign * Integer.parseInt(expression.toString());
                break;
            }

            // 다음 부호까지 값 저장
            else if (signMinus == -1 || (signPlus > 0 && signPlus < signMinus)) {   // +가 먼저 오는 경우
                result += sign * Integer.parseInt(expression.substring(0, signPlus));
                expression.delete(0, signPlus);
            }
            else {                                                                  // -가 먼저 오는 경우
                result += sign * Integer.parseInt(expression.substring(0, signMinus));
                expression.delete(0, signMinus);
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();

        br.close();
        bw.close();
    }
}
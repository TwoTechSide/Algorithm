import java.io.*;
import java.util.*;

class Computer {

    public int number;
    public int lastTime;
    public int count;

    public Computer(int number, int lastTime) {
        this.number = number;
        this.lastTime = lastTime;
        this.count = 1;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] p = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            p[i][0] = Integer.parseInt(st.nextToken());
            p[i][1] = Integer.parseInt(st.nextToken());
        }

        // 문제 풀이
        // 사용자 -> 시작 시간 오름차순 정렬
        // 사용중인 컴퓨터 -> 종료시간 오름차순 정렬
        // 비어있는 컴퓨터 -> 컴퓨터 번호 오름차순 정렬

        Arrays.sort(p, Comparator.comparingInt(o -> o[0]));

        // emptyCom : 컴퓨터 번호만 오름차순 저장
        // fullCom : [컴퓨터 번호, 마지막 사용시간]에 대해 마지막 사용 시간으로 오름차순 저장
        PriorityQueue<Computer> emptyCom = new PriorityQueue<>(Comparator.comparingInt(o -> o.number));
        PriorityQueue<Computer> usingCom = new PriorityQueue<>(Comparator.comparingInt(o -> o.lastTime));

        usingCom.add(new Computer(1, p[0][1]));
        int computerNumber = 1;

        for (int i = 1; i < N; i++) {
            int[] nextUser = p[i];

            // 다음 사용자 시간에 비어있는 컴퓨터 확인
            while (!usingCom.isEmpty() && usingCom.peek().lastTime < nextUser[0]) {
                emptyCom.add(usingCom.poll());
            }

            // 만약 비어있는 컴퓨터가 없는 경우
            if (emptyCom.isEmpty()) {
                usingCom.add(new Computer(++computerNumber, nextUser[1]));
            }

            // 만약 비어있는 컴퓨터가 있는 경우
            else {
                Computer computer = emptyCom.poll();
                computer.lastTime = nextUser[1];
                computer.count++;
                usingCom.add(computer);
            }
        }

        while (!usingCom.isEmpty())
            emptyCom.add(usingCom.poll());

        bw.write(computerNumber + "\n");
        while (!emptyCom.isEmpty())
            bw.write(emptyCom.poll().count + " ");

        bw.flush();

        br.close();
        bw.close();
    }
}
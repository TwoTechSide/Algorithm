import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static class Student implements Comparable<Student> {
        String name;
        int korea;
        int english;
        int math;

        public Student(String name, int korea, int english, int math) {
            this.name = name;
            this.korea = korea;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if (korea != o.korea) return o.korea - korea;
            if (english != o.english) return english - o.english;
            if (math != o.math) return o.math - math;
            return name.compareTo(o.name);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Student> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Student(
                    st.nextToken(),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            ));
        }

        while(!pq.isEmpty()) {
            Student s = pq.poll();
            bw.write(s.name + "\n");
        }

        bw.flush();

        br.close();
        bw.flush();
    }
}
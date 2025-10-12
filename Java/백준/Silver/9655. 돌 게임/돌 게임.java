import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        int N = readInt();
        
        System.out.println((N & 1) == 1 ? "SK" : "CY");
    }

    public static int readInt() throws IOException {
        int N = 0, c;
        while ((c = System.in.read()) > 32)
            N = N * 10 + c - '0';
        return N;
    }
}
import java.io.*;
import java.util.*;

public class Main {

    private static void solve() {
        System.out.println("Hello World!");















    }

    public static void main(String[] args) throws IOException {
        int t = sc.NextInt();
        while (t>0){
            solve();
            t--;
        }
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj).replace("], ", "]\n"));
    }

    static void debugV2(Object... obj) {
        System.out.println(Arrays.deepToString(obj)
                .replace("],", "\n").replace(",", "\t")
                .replaceAll("[\\[\\]]", " "));
    }

    static class Sc implements Closeable {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public Sc() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Sc(String file_name) throws IOException {
            try {
                din = new DataInputStream(new FileInputStream(file_name));
            } catch (Exception e) {
                din = new DataInputStream(System.in);
            }
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        private byte Next() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        private boolean isWhiteSpace(int n) {
            return n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == '\0';
        }

        public String NextWord() throws IOException {
            StringBuilder sb = new StringBuilder();
            int n = Next();
            while (isWhiteSpace(n))
                n = Next();
            while (!isWhiteSpace(n)) {
                sb.append((char) n);
                n = Next();
            }
            return sb.toString();
        }

        public String NextLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = Next()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int NextInt() throws IOException {
            int ret = 0;
            byte c = Next();
            while (c <= ' ') c = Next();
            boolean neg = (c == '-');
            if (neg) c = Next();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = Next()) >= '0' && c <= '9');
            if (neg) ret = -ret;
            return ret;
        }

        public long NextLong() throws IOException {
            long ret = 0;
            byte c = Next();
            while (c <= ' ') c = Next();
            boolean neg = (c == '-');
            if (neg) c = Next();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = Next()) >= '0' && c <= '9');
            if (neg) ret = -ret;
            return ret;
        }

        public double NextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = Next();
            while (c <= ' ') c = Next();
            boolean neg = (c == '-');
            if (neg) c = Next();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = Next()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = Next()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            if (neg) ret = -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = '\0';
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }

    static class Print {
        private final OutputStream out;

        public Print() {
            this.out = System.out;
        }

        public void print(String str) throws IOException {
            for (int i = 0; i < str.length(); i++) {
                out.write(str.charAt(i));
            }
        }

        public void println(String str) throws IOException {
            print(str);
            out.write('\n');
        }

        public void close() throws IOException {
            out.close();
        }
    }

    static Sc sc;

    static {
        try {
            sc = new Sc("input.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
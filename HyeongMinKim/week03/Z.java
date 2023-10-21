import java.io.*;
import java.util.StringTokenizer;

class Main {
    static int result = 0;
    static int r;
    static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()); //행
        c = Integer.parseInt(st.nextToken()); //열
        int size = (int) Math.pow(2, N); //2^N

        partition(0, 0, size);
        System.out.println(result - 1);
    }

    private static void partition(int startX, int startY, int size) {
        //1x1 or 2x2 격자일 경우
        if(size <= 2){
            findXY(startX, startY);
            return;
        }

        int half = size/2;
        //찾으려는 r행 c열이 왼쪽 상단 or 오른쪽 상단 or 왼쪽 하단 or 오른쪽 하단 중 어느 위치인지 판단
        boolean left =          startX <= c && c < startX + half;
        boolean right =  startX + half <= c && c < startX + size;
        boolean top =           startY <= r && r < startY + half;
        boolean bottom = startY + half <= r && r < startY + size;


        if(left && top){ //왼쪽 하단
            partition(startX, startY, half);

        }else if(right && top){ //오른쪽 상단
            result = result + ((half * half) * 1);
            partition(startX+half, startY, half);

        }else if(left && bottom){ //왼쪽 하단
            result = result + ((half * half) * 2);
            partition(startX, startY+half, half);

        }else if(right && bottom){ //오른쪽 상단
            result = result + ((half * half) * 3);
            partition(startX+half, startY+half, half);
        }

    }


    //분할된 1x1 or 2x2 격자에서 원하는 r행 c열의 값 찾기
    private static boolean findXY(int startX, int startY){
        //Z 방향으로 확인
        for (int j = startY; j < startY + 2; j++) {
            for (int i = startX; i < startX+2; i++) {
                result++;
                if (j == r && i == c) {
                    return true;
                }
            }
        }

        return false;
    }
}

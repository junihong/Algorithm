package tamsil.baekjoon.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4963 {
    static StringTokenizer st;
    static int N, M;
    static int[][] arr;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {-1, -1}, {1, -1}, {-1, 0}, {-1, -1}};

    static void dfs(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(nx < 1 || ny < 1 || nx > N || ny > M) continue;
            if(visit[nx][ny]) continue;
            if(arr[nx][ny] != 1) continue;
            dfs(nx, ny);
        }
    }

    static void solution() {
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (!visit[i][j] && arr[i][j] == 1) {
                    ans++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            arr = new int[N + 1][M + 1];
            visit = new boolean[N + 1][M + 1];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= M; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            if(N==0 && M==0) break;
            solution();
        }
    }
}
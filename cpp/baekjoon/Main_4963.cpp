#include <iostream>
#include <queue>

using namespace std;
#define NM 105

int N;
int arr[NM][NM];
bool visited[NM];

void bfs(int start) {
    queue<int> q;
    for (int i = 1; i <= N; i++) {
        visited[i] = false;
    }
    q.push(start);
    while (!q.empty()) {
        int x = q.front();
        q.pop();
        for (int y = 1; y <= N; y++) {
            if(arr[x][y] == 0) continue;
            if(visited[y]) continue;
            visited[y] = true;
            q.push(y);
        }
    }

    for (int i = 1; i <= N; i++) {
        cout << (visited[i] ? 1 : 0) << ' ';
    }
    cout << '\n';
}

void solution() {
    for (int i = 1; i <= N; i++) {
        bfs(i);
    }
}

void input() {
    cin >> N;
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            cin >> arr[i][j];
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    input();
    solution();
    return 0;
}
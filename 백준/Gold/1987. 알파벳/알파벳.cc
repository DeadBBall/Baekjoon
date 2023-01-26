#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

bool visit[26];
int dy[] = {1, -1, 0, 0};
int dx[] = {0, 0, 1, -1};
int r, c, ans = 1;
string map[20];

void dfs(int y, int x, int cnt)
{
    for(int i = 0; i < 4; i++)
    {
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= r || nx >= c || visit[map[ny][nx] - 'A'])
            continue;
        visit[map[ny][nx] - 'A'] = true;
        dfs(ny, nx, cnt + 1);
        visit[map[ny][nx] - 'A'] = false;
    }
    ans = max(ans , cnt);
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> r >> c;
    for(int y = 0; y < r; y++)
        cin >> map[y];
    visit[map[0][0] - 'A'] = true;
    dfs(0, 0, 1);
    cout << ans;
}
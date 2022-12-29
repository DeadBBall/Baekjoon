#include <iostream>
using namespace std;

bool paper[101][101];
int main()
{
	ios::sync_with_stdio(false);
	cout.tie(NULL);
	cin.tie(NULL);
	int n, ans = 0;
	cin >> n;
	for(int i = 0; i < n; i++)
	{
		int a, b;
		cin >> a >> b;
		for(int y = b; y < b + 10; y++)
			for(int x = a; x < a + 10; x++)
				paper[y][x] = 1;
	}
	for(int y = 1; y <= 100; y++)
		for(int x = 1; x <= 100; x++)
			if(paper[y][x] == 1)
				ans++;
	cout << ans;
}
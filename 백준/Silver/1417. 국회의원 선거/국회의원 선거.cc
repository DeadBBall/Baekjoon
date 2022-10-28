#include <iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int n, can[50];
	cin >> n;
	int ans = 0;
	for(int i = 0; i < n; i++)
		cin >> can[i];
	while(true)
	{
		int idx = 0;
		int max = 0;
		for(int i = 0; i < n; i++)
			if(max <= can[i])
			{
				idx = i;
				max = can[i];
			}
		if(idx == 0)
		{
			cout << ans;
			return (0);
		}
		else
		{
			can[0]++;
			can[idx]--;
			ans++;
		}
	}
	return (0);
}
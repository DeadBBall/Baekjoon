#include <iostream>
using namespace std;

int arr[10000];
int main()
{
	ios::sync_with_stdio(false);
	cout.tie(NULL);
	cin.tie(NULL);
	int n, m, ans = 0;
	cin >> n >> m;
	for(int i = 0; i < n; i++)
		cin >> arr[i];
	for(int i = 0; i < n; i++)
	{
		int sum = 0;
		for(int j = i; j < n; j++)
		{
			sum += arr[j];
			if(sum == m)
			{
				ans++;
				break;
			}
			else if(sum > m)
				break;
		}
	}
	cout << ans;
}

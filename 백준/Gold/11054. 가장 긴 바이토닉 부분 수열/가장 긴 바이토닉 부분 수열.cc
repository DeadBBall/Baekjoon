#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, ans = 1, arr[1000], dp[1000], r_dp[1000];
	cin >> n;
	for(int i = 0; i < n; i++)
		cin >> arr[i];
	dp[0] = 1;
	for(int i = 1; i < n; i++)
	{
		dp[i] = 1;
		for(int j = 0; j < i; j++)
			if(arr[j] < arr[i])
				dp[i] = max(dp[i], dp[j] + 1);
	}
	r_dp[n - 1] = 1;
	for(int i = n - 2; i >= 0; i--)
	{
		r_dp[i] = 1;
		for(int j = n - 1; j > i; j--)
			if(arr[i] > arr[j])
				r_dp[i] = max(r_dp[i], r_dp[j] + 1);
	}
	for(int i = 0; i < n; i++)
		ans = max(dp[i] + r_dp[i] - 1, ans);
	cout << ans;
}
#include <iostream>
using namespace std;

int road[100000], gasoline[100000];

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, minPrice = 1000000001;
	unsigned long long ans = 0;
	cin >> n;
	for(int i = 0; i < n - 1; i++)
		cin >> road[i];
	for(int i = 0; i < n; i++)
		cin >> gasoline[i];
	for(int i = 0; i < n; i++)
	{
		minPrice = min(minPrice, gasoline[i]);
		ans += road[i] * minPrice;
	}
	cout << ans;
}
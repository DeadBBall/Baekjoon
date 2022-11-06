#include <iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, car[5], ans = 0;
	cin >> n;
	for(int i = 0; i < 5; i++)
		cin >> car[i];
	for(int i = 0; i < 5; i++)
		if(car[i] == n)
			ans++;
	cout << ans;
}
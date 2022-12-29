#include <iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int t;
	cin >> t;
	while(t--)
	{
		unsigned long long n;
		cin >> n;
		cout << (n % 10 == 0 ? 1 : 0) << "\n";
	}
}
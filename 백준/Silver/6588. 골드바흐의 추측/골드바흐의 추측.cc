#include <iostream>
#include <cmath>
using namespace std;

bool primeNum[1000001];

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	for(int i = 3; i <= sqrt(1000000); i += 2)
	{
		if(primeNum[i])
			continue;
		for (int j = i * i; j <= 1000000; j += i)
		{
			primeNum[j] = true;
		}
	}
	while(true)
	{
		int n;
		cin >> n;
		if(n == 0)
		{
			return 0;
		}
		bool flag = false;
		for(int i = 3; i <= n / 2; i += 2)
		{
			if(!primeNum[i] && !primeNum[n - i])
			{
				cout << n << " = " << i << " + " << n - i << "\n";
				flag = true;
				break;
			}
		}
		if(!flag)
		{
			cout << "Goldbach's conjecture is wrong.";
		}
	}
}
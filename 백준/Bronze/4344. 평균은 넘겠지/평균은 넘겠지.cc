#include <iostream>
#include <cmath>

using namespace std;

int main()
{
	int c;
	cin >> c;
	for(int i = 0; i < c; i++)
	{
		int n;
		cin >> n;
		int a[n];
		float sum = 0;
		for(int j = 0; j < n; j++)
		{
			cin >> a[j];
			sum += a[j];
		}
		sum /= n;
		double ans = 0;
		for(int j = 0; j < n; j++)
		{
			if(sum < a[j])
				ans++;
		}
		printf("%.3lf%%\n", round(ans / n * 100000) / 1000);
	}
}
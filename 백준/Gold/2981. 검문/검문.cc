#include <iostream>
#include <algorithm>
#include <cmath>
#include <vector>
using namespace std;

int arr[100], n;
vector<int> v;
void input()
{
	cin >> n;
	for(int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}
	sort(arr, arr + n);
}

int makeNum(int a, int b)
{
	if(b == 0)
	{
		return 0;
	}

	while(b > 0)
	{
		int tmp = a;
		a = b;
		b = tmp % b ;
	}
	return a;
}

void checkNum()
{
	int num = arr[1] - arr[0];
	for(int i = 2; i < n; i++)
	{
		int diff = arr[i] - arr[i - 1];
		num = makeNum(num, diff);
	}

	for(int i = 1; i <= sqrt(num); i++)
	{
		if(num % i == 0)
		{
			if(num / i == i)
			{
				v.push_back(i);
			}
			else
			{
				v.push_back(i);
				v.push_back(num / i);
			}
		}
	}
	sort(v.begin(), v.end());
	for(int i = 1; i < v.size(); i++)
	{
		cout << v[i] << " ";
	}
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	input();
	checkNum();
}

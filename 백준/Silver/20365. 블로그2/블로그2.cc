#include <iostream>
#include <vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cout.tie(NULL);
	cin.tie(NULL);
	int n, r = 0, b = 0, now = -1;
	cin >> n;
	vector<char> v;
	for(int i = 0; i < n; i++)
	{
		char tmp;
		cin >> tmp;
		if(now == -1)
		{
			if(tmp == 'R')
			{
				now = 0;
				v.push_back('R');
			}
			else
			{
				now = 1;
				v.push_back('B');
			}
		}
		else if(now == 0)
		{
			if(tmp == 'B')
			{
				now = 1;
				v.push_back('B');
			}
		}
		else
		{
			if(tmp == 'R')
			{
				now = 0;
				v.push_back('R');
			}
		}
	}
	for(int i = 0; i < v.size(); i++)
	{
		if(v[i] == 'R')
			r++;
		else
			b++;
	}
	if(r > b)
		cout << b + 1;
	else
		cout << r + 1;
}
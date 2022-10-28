#include <iostream>
#include <algorithm>
using namespace std;
typedef pair<int, int> pii;

pii x[1000000];
int n;
bool compare(pii p, pii p2)
{
	return p.second < p2.second;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> n;
	for(int i = 0; i < n; i++)
	{
		int tmp;
		cin >> tmp;
		x[i] = make_pair(tmp, i);
	}
	sort(x, x + n);
	int compact = 0;
	int flag = 0;
	for(int i = 0; i < n; i++)
	{
		if(i < n - 1 && x[i].first == x[i + 1].first)
			flag = 1;
		x[i].first = compact;
		compact++;
		if(flag == 1)
		{
			compact--;
			flag = 0;
		}
	}
	sort(x, x + n, compare);
	for(int i = 0; i < n; i++)
		cout << x[i].first << " ";
}
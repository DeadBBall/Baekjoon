#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
typedef pair<string, string> pss;

bool cmp(pss a, pss b)
{
	return a.second > b.second;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int t;
	cin >> t;
	for(int i = 0; i < t; i++)
	{
		vector<pss> v;
		int n;
		cin >> n;
		for(int j = 0; j < n; j++)
		{
			string inputFashion;
			string inputType;
			cin >> inputFashion >> inputType;
			v.push_back(make_pair(inputFashion, inputType));
		}
		sort(v.begin(), v.end(), cmp);
		vector<int> vc;
		int numTmp = 1;
		for(auto it = v.begin(); it != v.end(); it++)
		{
			if(it + 1 != v.end() && (*it).second.compare((*(it + 1)).second) == 0)
				numTmp++;
			else
			{
				vc.push_back(numTmp + 1);
				numTmp = 1;
			}
		}
		int ans = 1;
		for(auto it = vc.begin(); it != vc.end(); it++)
			ans *= (*it);
		cout << ans - 1 << "\n";
	}
}
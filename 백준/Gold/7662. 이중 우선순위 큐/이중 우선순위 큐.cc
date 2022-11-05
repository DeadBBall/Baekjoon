#include <iostream>
#include <set>
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
		int k;
		cin >> k;
		multiset<int> ms;
		for(int i = 0; i < k; i++)
		{
			string input;
			int inputNum;
			cin >> input >> inputNum;
			if(input.compare("I") == 0)
				ms.insert(inputNum);
			else
			{
				if(ms.empty())
					continue;
				if(inputNum == -1)
					ms.erase(ms.begin());
				else
				{
					auto iter = ms.end();
					iter--;
					ms.erase(iter);
				}
			}
		}
		if(ms.empty())
			cout << "EMPTY" << "\n";
		else
		{
			auto iter = ms.end();
			iter--;
			cout << *iter << ' ' << *ms.begin() << '\n';
		}
	}
}
#include <iostream>
#include <queue>
#include <cstdlib>
using namespace std;

typedef pair<int, int> pii;

struct cmp {
  bool operator()(pii a, pii b) {
  if(a.second == b.second)
		return a.first > b.first;
	return a.second > b.second;
  }
};

int main()
{
	priority_queue<pii, vector<pii>, cmp> pq;
	int n;
	cin >> n;
	for(int i = 0; i < n; i++)
	{
		int inputNum;
		cin >> inputNum;
		if(inputNum == 0)
		{
			if(pq.empty())
				cout << "0\n";
			else
			{
				cout << pq.top().first << "\n";
				pq.pop();
			}
		}
		else
			pq.emplace(inputNum, abs(inputNum));
	}
}

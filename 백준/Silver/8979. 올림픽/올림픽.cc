#include <iostream>
#include <queue>
using namespace std;

struct medal
{
	int num;
	int gold;
	int silver;
	int bronze;
};

struct cmp
{
	bool operator() (medal a, medal b)
	{
		if(a.gold == b.gold)
		{
			if(a.silver == b.silver)
				return a.bronze < b.bronze;
			return a.silver < b.silver;
		}
		return a.gold < b.gold;
	}
};

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	priority_queue<medal, vector<medal>, cmp> pq;
	int n, k;
	cin >> n >> k;
	for(int i = 0; i < n; i++)
	{
		medal tmp;
		cin >> tmp.num >> tmp.gold >> tmp.silver >> tmp.bronze;
		pq.push(tmp);
	}
	int rank = 1;
	int dup = 1;
	while(!pq.empty())
	{
		if(pq.top().num == k)
			cout << rank;
		medal tmp = pq.top();
		pq.pop();
		if(pq.top().gold != tmp.gold)
		{
			rank += dup;
			dup = 1;
		}
		else if(pq.top().silver != tmp.silver)
		{
			rank += dup;
			dup = 1;
		}
		else if(pq.top().bronze != tmp.bronze)
		{
			rank += dup;
			dup = 1;
		}
		else
			dup++;
	}
}
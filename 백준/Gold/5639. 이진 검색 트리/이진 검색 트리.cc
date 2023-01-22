#include <iostream>
#include <vector>
using namespace std;

int tree[10000];

void LRV(int start, int end)
{
	if(start >= end)
		return;
	if (start == end - 1)
	{
		cout << tree[start] << '\n';
		return;
	}
	int idx = start + 1;
	while (idx < end)
	{
		if (tree[start] < tree[idx])
			break;
		idx++;
	}
	LRV(start + 1, idx);
	LRV(idx, end);
	cout << tree[start] << '\n';
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int num;
	int idx = 0;
	while(cin >> num)
	{
		tree[idx++] = num;
	}
	LRV(0, idx);
}
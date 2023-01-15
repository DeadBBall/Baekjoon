#include <iostream>
#include <vector>
#include <cmath>
using namespace std;
typedef long long ll;
typedef pair<int, ll> pill;

ll arr[1000001];
vector <ll> tree;
int n, m, k;

ll makeTree(int node, int start, int end)
{
	if(start == end)
	{
		tree[node] = arr[start];
		return tree[node];
	}
	int mid = (start + end) / 2;
	tree[node] = makeTree(node * 2, start, mid) + makeTree(node * 2 + 1, mid + 1, end);
	return tree[node];
}

ll calculateSum(int node, int start, int end, int left, int right)
{
	if (left > end || right < start)
		return 0;
	if (left <= start && end <= right)
		return tree[node];
	int mid = (start + end) / 2;
	return calculateSum(node * 2, start, mid, left, right) + calculateSum(node * 2 + 1, mid + 1, end, left, right);
}

ll changeTree(int node, int start, int end, int objNode, ll input)
{
	if(objNode < start || objNode > end)
		return tree[node];
	if(objNode == start && start == end)
	{
		tree[node] = input;
		return tree[node];
	}
	int mid = (start + end) / 2;
	tree[node] = changeTree(node * 2, start, mid, objNode, input) + changeTree(node * 2 + 1, mid + 1, end, objNode, input);
	return tree[node];
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m >> k;
	int h = ceil(log2(n));
	tree.resize(1 << (h + 1));
	for(int i = 0; i < n; i++)
		cin >> arr[i];
	makeTree(1, 0, n - 1);
	for(int i = 0; i < m + k; i++)
	{
		int a, b;
		ll c;
		cin >> a >> b >> c;
		if(a == 1)
			changeTree(1, 0, n - 1, b - 1, c);
		else
			cout << calculateSum(1, 0, n - 1, b - 1, c - 1) << "\n";
	}
}
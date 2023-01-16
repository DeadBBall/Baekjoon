#include <iostream>
#include <vector>
#include <cmath>
using namespace std;
typedef long long ll;
#define MAX 1000000001;
#define MIN 0;

int n, m;
vector<int> minTree;
vector<int> arr;
vector<int> maxTree;

int makeMinTree(int node, int start, int end)
{
	if(start == end)
	{
		minTree[node] = arr[start];
		return minTree[node];
	}
	int mid = (start + end) / 2;
	minTree[node] = min(makeMinTree(node * 2, start, mid), makeMinTree(node * 2 + 1, mid + 1, end));
	return minTree[node];
}

int makeMaxTree(int node, int start, int end)
{
	if(start == end)
	{
		maxTree[node] = arr[start];
		return maxTree[node];
	}
	int mid = (start + end) / 2;
	maxTree[node] = max(makeMaxTree(node * 2, start, mid), makeMaxTree(node * 2 + 1, mid + 1, end));
	return maxTree[node];
}

int searchMin(int node, int start, int end, int left, int right)
{
	if(left > end || right < start)
		return MAX;
	if(left <= start && end <= right)
		return minTree[node];
	int mid = (start + end) / 2;
	return min(searchMin(node * 2, start, mid, left, right), searchMin(node * 2 + 1, mid + 1, end, left, right));
}

int searchMax(int node, int start, int end, int left, int right)
{
	if(left > end || right < start)
		return MIN;
	if(left <= start && end <= right)
		return maxTree[node];
	int mid = (start + end) / 2;
	return max(searchMax(node * 2, start, mid, left, right), searchMax(node * 2 + 1, mid + 1, end, left, right));
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m;
	int h = ceil(log2(n));
	minTree.resize(1 << (h + 1));
	maxTree.resize(1 << (h + 1));
	arr.resize(n);
	for(int i = 0; i < n; i++)
		cin >> arr[i];
	makeMinTree(1, 0, n -1);
	makeMaxTree(1, 0, n -1);
	for(int i = 0; i < m; i++)
	{
		int a, b;
		cin >> a >> b;
		cout << searchMin(1, 0, n - 1, a - 1, b - 1) << " " << searchMax(1, 0, n - 1, a - 1, b - 1) << "\n";
	}
}
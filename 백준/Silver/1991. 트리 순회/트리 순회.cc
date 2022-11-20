#include <iostream>
#include <stack>
using namespace std;

int n, tree[27][2] = {0};

void VLR(int node)
{
	if(node == -1)
		return;
	cout << (char)(node + 'A');
	VLR(tree[node][0]);
	VLR(tree[node][1]);
}

void LVR(int node)
{
	if(node == -1)
		return;
	LVR(tree[node][0]);
	cout << (char)(node + 'A');
	LVR(tree[node][1]);
}

void LRV(int node)
{
	if(node == -1)
		return;
	LRV(tree[node][0]);
	LRV(tree[node][1]);
	cout << (char)(node + 'A');
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for(int i = 1; i <= n; i++)
	{
		char tmpNode, tmpLeft, tmpRight;
		cin >> tmpNode >> tmpLeft >> tmpRight;
		int node = tmpNode - 'A';
		int left = tmpLeft;
		int right = tmpRight;
		if(left != 46)
			tree[node][0] = left - 'A';
		else
			tree[node][0] = -1;
		if(right != 46)
			tree[node][1] = right - 'A';
		else
			tree[node][1] = -1;
	}
	VLR(0);
	cout << "\n";
	LVR(0);
	cout << "\n";
	LRV(0);
}
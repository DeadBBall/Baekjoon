#include <iostream>
#include <queue>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	queue<int> q;
	int n;
	cin >> n;
	while(n--)
	{
		string input;
		cin >> input;
		if(input.compare("push") == 0)
		{
			int num;
			cin >> num;
			q.push(num);
		}
		else if(input.compare("front") == 0)
		{
			if(q.empty())
				cout << "-1\n";
			else
				cout << q.front() << "\n";
		}
		else if(input.compare("back") == 0)
		{
			if(q.empty())
				cout << "-1\n";
			else
				cout << q.back() << "\n";
		}
		else if(input.compare("pop") == 0)
		{
			if(q.empty())
				cout << "-1\n";
			else
			{
				cout << q.front() << "\n";
				q.pop();
			}
		}
		else if(input.compare("size") == 0)
			cout << q.size() << "\n";
		else
		{
			if(q.empty())
				cout << "1\n";
			else
				cout << "0\n";
		}
	}
}
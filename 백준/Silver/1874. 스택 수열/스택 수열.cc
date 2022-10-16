#include <iostream>
#include <stack>
#include <vector>
using namespace std;

int main()
{
	stack<int> s;
	vector<char> result;
	int n, num = 1;
	cin >> n;
	for(int i = 0; i < n; i++)
	{
		int tmp;
		cin >> tmp;
		while(num <= tmp)
		{
			s.push(num++);
			result.push_back('+');
		}
		if (s.top() == tmp)
		{
			s.pop();
			result.push_back( '-' );
		}
		else
		{
			cout << "NO";
			return 0;
		}
	}
	for(int i = 0; i < (int)result.size(); i++)
		cout << result[i] << "\n";
}
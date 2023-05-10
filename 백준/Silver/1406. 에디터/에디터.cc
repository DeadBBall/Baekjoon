#include <iostream>
#include <algorithm>
#include <string>
#include <stack>
using namespace std;

int n;
string str;
stack<char> leftS, rightS;
int main()
{
	cin.tie(0);
	cout.tie(0);
	ios::sync_with_stdio(0);
	cin >> str;
	cin >> n;
	for(int i = 0; i < str.length(); i++)
	{
		leftS.push(str[i]);
	}
	for(int i = 0; i < n; i++)
	{
		char input;
		cin >> input;
		switch (input)
		{
		case 'L':
			if(!leftS.empty())
			{
				rightS.push(leftS.top());
				leftS.pop();
			}
			break;
		case 'D':
		if(!rightS.empty())
		{
			leftS.push(rightS.top());
			rightS.pop();
		}
			break;
		case 'B':
		if(!leftS.empty())
		{
			leftS.pop();
		}
			break;
		default:
			cin >> input;
			leftS.push(input);
			break;
		}
	}
	while(!leftS.empty())
	{
		rightS.push(leftS.top());
		leftS.pop();
	}
	while(!rightS.empty())
	{
		cout << rightS.top();
		rightS.pop();
	}
}
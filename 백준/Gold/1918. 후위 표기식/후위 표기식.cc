#include <iostream>
#include <stack>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	string formula;
	cin >> formula;
	stack<char> s;
	int i = 0;
	while(formula[i] != 0)
	{
		if(isalpha(formula[i]))
			cout << formula[i];
		else
		{
			if(formula[i] == '(')
				s.push(formula[i]);
			else if(formula[i] == '*' || formula[i] == '/')
			{
				while(!s.empty() && (s.top() == '*' || s.top() == '/'))
				{
					cout << s.top();
					s.pop();
				}
				s.push(formula[i]);
			}
			else if(formula[i] == '+' || formula[i] == '-')
			{
				while(!s.empty() && s.top() != '(')
				{
					cout << s.top();
					s.pop();
				}
				s.push(formula[i]);
			}
			else if(formula[i] == ')')
			{
				while(!s.empty() && s.top() != '(')
				{
					cout << s.top();
					s.pop();
				}
				s.pop();
			}
		}
		i++;
	}
	while(!s.empty())
	{
		cout << s.top();
		s.pop();
	}
}
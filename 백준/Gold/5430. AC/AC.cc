#include <iostream>
#include <string>
#include <deque>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int t;
	cin >> t;
	for(int i = 0; i < t; i++)
	{
		string inputFunction;
		cin >> inputFunction;
		int n;
		cin >> n;
		deque <int> d;
		string inputArr;
		cin >> inputArr;
		string tmp = "";
		for(int i = 0; i < inputArr.length(); i++)
		{
			if(isdigit(inputArr[i]))
				tmp += inputArr[i];
				// d.push_back(stoi(&inputArr[i]));
				// i += to_string(stoi(&inputArr[i])).length();
			else
				if(!tmp.empty())
				{
					d.push_back(stoi(tmp));
					tmp = "";
				}
		}
		int flag = 0;
		for(int i = 0; i < inputFunction.length(); i++)
		{
			if(inputFunction[i] == 'R')
			{
				if(flag == 0)
					flag = 1;
				else
					flag = 0;
			}
			else
			{
				if(d.empty())
				{
					cout << "error\n";
					flag = -1;
					break;
				}
				if(flag == 1)
					d.pop_back();
				else
					d.pop_front();
			}
		}
		if(flag == -1)
			continue;
		cout << "[";
		if(flag == 0)
		{
			for(auto it = d.begin(); it != d.end(); it++)
			{
				cout << *it;
				if(it + 1 != d.end())
					cout << ",";
			}
			cout << "]\n";
		}
		if(flag == 1)
		{
			for(auto it = d.rbegin(); it != d.rend(); it++)
			{
				cout << *it;
				if(it + 1 != d.rend())
					cout << ",";
			}
			cout << "]\n";
		}
	}
}
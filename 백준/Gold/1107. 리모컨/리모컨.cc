#include <iostream>
#include <cstdlib>
#include <string>
using namespace std;

int n;
int brokenButtonNum = 0;
int	brokenButton[10] = {0};

bool check(int num)
{
	string objNum = to_string(num);
	for(int idx = 0; idx < objNum.size(); idx++)
	{
		if(brokenButton[objNum[idx] - '0'] == 1)
			return false;
	}
	return true;
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> brokenButtonNum;
	int inputTmp;
	for(int i = 0; i < brokenButtonNum; i++)
	{
		cin >> inputTmp;
		brokenButton[inputTmp]++;
	}
	int ans = abs(100 - n);
	for(int i = 0; i <= 1000000; i++)
	{
    if(check(i))
		{
      int tmp = abs(n-i)+to_string(i).length();
      ans= min(ans,tmp);
    }
	}
	cout << ans;
}
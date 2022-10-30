#include <iostream>
#include <map>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, m;
	cin >> n >> m;
	map<string, string> notepad;
	for(int i = 0; i < n; i++)
	{
		string siteName;
		string pswd;
		cin >> siteName >> pswd;
		notepad.insert({siteName, pswd});
	}
	for(int i = 0; i < m; i++)
	{
		string inputSiteName;
		cin >> inputSiteName;
		cout << notepad[inputSiteName] << "\n";
	}
}
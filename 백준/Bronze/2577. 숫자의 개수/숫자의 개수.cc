#include <iostream>
#include <string>
using namespace std;

int	numberOutput[10] = {0};
int main()
{
	int a, b, c;
	cin >> a >> b>> c;
	string mult = to_string(a * b * c);
	for(int i=mult.size()-1; i>=0; i--)
		numberOutput[mult[i]-'0']++;
	for(int i = 0; i < 10; i++)
		cout << numberOutput[i] << "\n";
}
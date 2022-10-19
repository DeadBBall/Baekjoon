#include <iostream>
using namespace std;

int n, paper[2187][2187], paperMinus = 0, paperZero = 0, paperPlus = 0;

void cutPaper(int inputY, int inputX, int size)
{
	int check = paper[inputY][inputX];
	for(int y = inputY; y < inputY + size; y++)
		for(int x = inputX; x < inputX + size; x++)
		{
			if(check != paper[y][x])
				check = 2;
			if(check == 2)
			{
				cutPaper(inputY, inputX, size / 3);
				cutPaper(inputY + size / 3, inputX, size / 3);
				cutPaper(inputY + size * 2 / 3, inputX, size / 3);
				cutPaper(inputY, inputX + size / 3, size / 3);
				cutPaper(inputY + size / 3, inputX + size / 3, size / 3);
				cutPaper(inputY + size * 2 / 3, inputX + size / 3, size / 3);
				cutPaper(inputY, inputX + size * 2 / 3, size / 3);
				cutPaper(inputY + size / 3, inputX + size * 2 / 3, size / 3);
				cutPaper(inputY + size * 2 / 3, inputX + size * 2 / 3, size / 3);
				return;
			}
		}
	if(check == -1)
		paperMinus++;
	else if(check == 0)
		paperZero++;
	else
		paperPlus++;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> n;
	for(int y = 0; y < n; y++)
		for(int x = 0; x < n; x++)
			cin >> paper[y][x];
	cutPaper(0, 0, n);
	cout << paperMinus << "\n" << paperZero << "\n" << paperPlus;
}
#include <iostream>
using namespace std;

int n, paper[128][128], blue = 0, white = 0;

void cutPaper(int y_obj, int x_obj, int size)
{
	int check = paper[y_obj][x_obj];
	for(int y = y_obj; y < y_obj + size; y++)
		for(int x = x_obj; x < x_obj + size; x++)
		{
			if(check != paper[y][x])
				check = -1;
			if(check == -1)
			{
				cutPaper(y_obj, x_obj, size / 2);
				cutPaper(y_obj + size / 2, x_obj, size / 2);
				cutPaper(y_obj, x_obj + size / 2, size / 2);
				cutPaper(y_obj + size / 2, x_obj + size / 2, size / 2);
				return;
			}
		}
	if(check == 0)
		white++;
	else
		blue++;
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
	cout << white << "\n" << blue;
}
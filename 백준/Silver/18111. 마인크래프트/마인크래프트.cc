#include <iostream>
using namespace std;

int main()
{
	int mine[500][500] = {0}, n, m, b, time = -1, height = -1, min_h = 256, max_h = 0;
	ios::sync_with_stdio(false);
  cin.tie(NULL);
	cin >> n >> m >> b;
	for(int y = 0; y < n; y++)
		for(int x = 0; x < m; x++)
		{
			cin >> mine[y][x];
			if(mine[y][x] < min_h)
				min_h = mine[y][x];
			if(mine[y][x] > max_h)
				max_h = mine[y][x];
		}
	for (int h = min_h; h <= max_h; h++)
	{
		int build = 0;
		int remove = 0;
		for (int y = 0; y < n; y++)
			for (int x = 0; x < m; x++)
			{
				int tmp_height = mine[y][x] - h;
				if (tmp_height > 0)
					remove += tmp_height;
				else if (tmp_height < 0)
					build -= tmp_height;
			}
		if (remove + b >= build)
		{
			int tmp_time = remove * 2 + build;
			if (time == -1 || time >= tmp_time)
			{
				time = tmp_time;
				height = h;
			}
		}
	}
	cout << time << " " << height;
}
#include <stdio.h>
int n, com[101] = {0}, line[101][101] = {0}, ans = 0;

void dfs (int v)
{
	com[v] = 1;
  for(int i = 1; i <= n; i++)
		if (line[v][i] && !com[i])
			{
				ans++;
				dfs(i);
			}
}

int main()
{
	int m, tmp, tmp2;
	scanf("%d%d", &n, &m);
	for(int i = 1; i <= m; i++)
	{
		scanf("%d%d", &tmp, &tmp2);
		line[tmp][tmp2] = 1;
		line[tmp2][tmp] = 1;
	}
	dfs(1);
	printf("%d", ans);
}
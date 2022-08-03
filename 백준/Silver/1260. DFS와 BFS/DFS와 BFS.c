#include <stdio.h>

int n, a[1001][1001] = {0}, b[1001] = {0}, queue[1001];

void dfs (int v)
{
	b[v] = 1;
	printf("%d ", v);
  for(int i = 1; i <= n; i++)
		if (a[v][i] && !b[i])
			dfs(i);
}

void bfs (int v)
{
	int frt = 0, rea = 1, pop;
	b[v] = 1;
	printf("%d ", v);
	queue[0] = v;
 	while(frt < rea)
	{
    pop = queue[frt++];
    for(int i = 1; i <= n; i++)
      if(a[pop][i] && !b[i])
			{
        b[i] = 1;
        printf("%d ", i);
        queue[rea++] = i;
      }
  }
}

int main()
{
	int m, v, beg, end;
	scanf("%d%d%d", &n, &m, &v);

	for (int i = 0; i < m; i++)
	{
		scanf("%d%d", &beg, &end);
		a[beg][end] = 1;
		a[end][beg] = 1;
	}
	dfs(v);
	for(int i = 1; i <= n; i++)
		b[i] = 0;
	b[v] = 1;
	printf("\n");
	bfs(v);
}
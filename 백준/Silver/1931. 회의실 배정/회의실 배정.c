#include <stdio.h>
#include <stdlib.h>

typedef struct
{
	int x;
	int y;
} gr;

int compare(const void *a, const void *b)
{
	gr c = *(gr*)a;
	gr d = *(gr*)b;
	if(c.y == d.y)
		return(c.x - d.x);
	else
		return(c.y - d.y);
}

int main()
{
	gr ar[100000];
	int n, ans = 1, j = 0;
	scanf("%d", &n);
	for(int i = 0; i < n; i++)
		scanf("%d%d", &ar[i].x, &ar[i].y);
	qsort(ar, n, sizeof(gr), compare);
	for(int i = 1; i < n; i++)
		if(ar[i].x >= ar[j].y)
		{
			j = i;
			ans++;
		}
	printf("%d", ans);
}
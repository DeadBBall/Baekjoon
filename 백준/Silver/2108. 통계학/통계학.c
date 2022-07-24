#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int compare(const void *a, const void *b)
{
    return *(int *)a - *(int *)b;
}
int mode(int list[], int n)
{
  int ar[8001] = { 0 };
	int i, idx, max = 0, cnt = 0;
	for (i = 0; i < n; i++)
	{
		idx = list[i] + 4000;
		ar[idx] += 1;
		if (ar[idx] > max)
			max = ar[idx];
	}
	for (i = 0, idx = 0; i < 8001 ; i++)
	{
		if (ar[i] == 0)
			continue;
		if (ar[i] == max)
		{
			if (cnt == 0)
			{
				idx = i;
				cnt += 1;
			}
			else if (cnt == 1)
			{
				idx = i;
				break;
			}
		}
	}
	return idx - 4000;
}

int main()
{
  int t;
  scanf("%d", &t);
  int n[500001];
  int max, min;
  double sum = 0;
  int ans;
  for(int i = 0; i < t; i++)
  {
    scanf("%d", &n[i]);
    sum += n[i];
    if(!i)
    {
      max = n[i];
      min = n[i];
    }
    if(n[i] > max)
      max = n[i];
    if(n[i] < min)
      min = n[i];
  }
  qsort(n, t, sizeof(int), compare);
  ans = round(sum / t);
  printf("%d\n%d\n%d\n%d", ans, n[t / 2], mode(n, t), max - min);
}
#include <stdio.h>
int main()
{
  int t, k, n;
  int a[15][15] = {0};
  for(int i = 0; i < 15; i++)
    a[0][i] = i;
  for(int i = 1; i < 15; i++)
  {
    for(int m = 1; m < 15; m++)
    {
      for(int j = 1; j <= m; j++)
        a[i][m] += a[i - 1][j];
    }
  }
  scanf("%d", &t);
  for(int i = 0; i < t; i++)
  {
    scanf("%d%d", &k, &n);
    printf("%d\n", a[k][n]);
  }
}
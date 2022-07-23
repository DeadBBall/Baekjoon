#include <stdio.h>

int help(int a[2][101], int start, int n)
{
  int tmp[2] = {0};
  for(int i = start; i != start - 1; i++)
  {
    if(tmp[0] < a[0][i])
    {
      tmp[0] = a[0][i];
      tmp[1] = i;
    }
    if(!start && i == n - 1)
      break;
    else if(start && i == n - 1)
      i = -1;
  }
  return (tmp[1]);
}

int main()
{
  int t;
  scanf("%d", &t);
  for(int i = 0; i < t; i++)
  {
    int n, m;
    scanf("%d%d", &n, &m);
    int a[2][101] = {0};
    int rank = 1;
    for(int j = 0; j < n; j++)
      scanf("%d", &a[0][j]);
    for(int j = 0; n != rank - 1; j++)
    {
      int tmp;
      tmp = help(a, j, n);
      a[1][tmp] = rank++;
      a[0][tmp] = 0;
      j = tmp;
      if (j + 1 == n)
        j = -1;
    }
    printf("%d\n", a[1][m]);
  }
}
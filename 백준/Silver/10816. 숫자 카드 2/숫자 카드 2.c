#include <stdio.h>

int main()
{
  int n, m;
  int a[20000001] = {0};
  scanf("%d", &n);
  for(int i = 0; i < n; i++)
  {
    int tmp;
    scanf("%d", &tmp);
    if(tmp < 0)
      tmp = tmp * -1 + 10000000;
    a[tmp]++;
  }
  scanf("%d", &m);
  for(int i = 0; i < m; i++)
  {
    int tmp;
    scanf("%d", &tmp);
    if(tmp < 0)
      tmp = tmp * -1 + 10000000;
    printf("%d ", a[tmp]);
  }
}
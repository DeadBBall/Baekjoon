#include <stdio.h>
int main()
{
  int n, i;
  int a[1000001];
  a[1] = 0;
  a[2] = 1;
  a[3] = 1;
  scanf("%d", &n);
  i = 4;
  while(i <= n)
  {
    int b = 0;
    int c = 0;
    int d = 1;
    if (i % 3 == 0)
      b++;
    if (i % 2 == 0)
      c++;
    if(b && c)
      a[i] = a[i / 3] > a[i / 2] ? a[i / 2] + 1 : a[i / 3] + 1;
    else if(b)
      a[i] = a[i / 3] > a[i - 1] ? a[i - 1] + 1 : a[i / 3] + 1;
    else if(c)
      a[i] = a[i - 1] > a[i / 2] ? a[i / 2] + 1 : a[i - 1] + 1;
    else
      a[i] = a[i - 1] + 1;
    i++;
  }
  printf("%d", a[n]);
}
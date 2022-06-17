#include <stdio.h>

int main()
{
  int t, h, w, n;
  int c[1000];
  scanf("%d", &t);
  for(int i = 0; i < t; i++)
  {
    scanf("%d %d %d", &h, &w, &n);
    if(n % h)
      c[i] = (n / h) + 1 + (n % h) * 100;
    else
      c[i] = (n / h) + h * 100;
  }
  for(int i = 0; i < t; i++)
    printf("%d\n", c[i]);
}
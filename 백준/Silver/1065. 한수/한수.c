#include <stdio.h>

int main()
{
  int n;
  scanf("%d", &n);
  if(n == 1000)
    n--;
  if(n < 100)
  {
    printf("%d", n);
    return (0);
  }
  int ans = 99;
  for(int i = 100; i <= n; i++)
  {
    if(i % 10 - i / 10 % 10 == i / 10 % 10 - i / 100 % 10)
      ans++;
  }
  printf("%d", ans);
}
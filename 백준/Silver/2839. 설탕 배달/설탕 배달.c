#include <stdio.h>
int main()
{
  int n;
  scanf("%d", &n);
  int ans = 0;
  while(1)
  {
    if(n % 5 != 0)
    {
      n -= 3;
      ans++;
      if(n < 0)
      {
        printf("-1");
        return (0);
      }
    }
    else
    {
      ans += n / 5;
      break;
    }
  }
  printf("%d", ans);
}
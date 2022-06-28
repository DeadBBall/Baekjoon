#include <stdio.h>

int main()
{
  int n, ans;
  scanf("%d", &n);
  if(n == 1)
  {
    printf("1");
    return (0);
  }
  else if(n == 2)
  {
    printf("2");
    return (0);
  }
  for(int i = 1; ;i *= 2)
  {
    if(i * 2 + 1 <= n)
    {
      if(n < i * 4 + 1)
      {
        ans = i;
        break;
      }
    }
  }
  printf("%d", (n - (ans * 2 + 1)) * 2 + 2);
}
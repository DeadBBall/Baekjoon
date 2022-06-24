#include <stdio.h>

int main()
{
  int n, k;
  scanf("%d %d", &n, &k);
  if(!k)
  {
    printf("1");
    return (0);
  }
  int ans = 1;
  for(int i = n; i > n - k; i--)
    ans *= i;
  for(int i = 1; i <= k; i++)
    ans /= i;
  printf("%d", ans);
}
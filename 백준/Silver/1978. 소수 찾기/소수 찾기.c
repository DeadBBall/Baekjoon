#include <stdio.h>

int main()
{
  int n;
  int a[200];
  int ans = 0;
  scanf("%d", &n);
  for(int i = 0; i < n; i++)
    scanf("%d", &a[i]);
  for(int i = 0; i < n; i++)
  {
    int j;
    if(a[i] == 1)
      i++;
    for(j = 2; j * j <= a[i]; j++)
    {
      if(a[i] % j == 0)
        break;
    }
    if(j * j > a[i])
      ans++;
  }
  printf("%d", ans);
}
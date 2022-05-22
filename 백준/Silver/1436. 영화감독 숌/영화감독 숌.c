#include <stdio.h>

int main()
{
  int n;
  int i = 1;
  int ans = 666;
  scanf("%d", &n);
  while (i <= n)
  {
    char c[11] = {0};
    sprintf(c, "%d", ans);
    for(int j = 0; j < 8; j++)
    {
      if(c[j] == '6' && c[j+1] == '6' && c[j+2] == '6')
      {  
        i++;
        break ;
      }
    }
    if(i<=n)
      ans++;
  }
  printf("%d", ans);
}
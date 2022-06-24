#include <stdio.h>

int main()
{
  int n, m;
  int ans = 0;
  int nu[101];
  scanf("%d %d", &n, &m);
  for(int i = 0; i < n; i++)
    scanf("%d", &nu[i]);
  for(int i = 0; i < n - 2; i++)
  {
    int tmp = 0;
    for(int j = 1; j < n - 1; j++)
    {
      for(int k = 2; k < n; k++)
      {
        if(i != j && j != k && i != k)
        {
          tmp = nu[i] + nu[j] + nu[k];
          if(ans < tmp && tmp <= m)
            ans = tmp;
        }
      }
    }
    if(ans == m)
      break;
  }
  printf("%d", ans);
}
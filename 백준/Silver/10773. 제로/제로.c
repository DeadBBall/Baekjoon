#include <stdio.h>

int main()
{
  int c[100001] = {0};
  int k;
  int cnt = 0;
  scanf("%d", &k);
  for(int i = 0; i < k; i++)
  {
    if(c[i - 1] == 0 && i != 0)
    {
      i--;
      k--;
    }
    int tmp;
    scanf("%d", &tmp);
    if(!tmp)
    {
      i--;
      k--;
    }
    c[i] = tmp;
  }
  int ans = 0;
  for(int i = 0; i < k; i++)
    ans += c[i];
  printf("%d", ans);
}
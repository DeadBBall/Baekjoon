#include <stdio.h>

int main()
{
  int c[10001] = {0};
  int n;
  int ans;
  scanf("%d", &n);
  for(int i = 1; i < n + 1; i++)
  {
    scanf("%d", &ans);
    c[ans]++;
  }
  for(int i = 1; i < 10001; i++)
  {
    if(c[i] != 0)
    {
      printf("%d\n", i);
      c[i]--;
      i--;
    }
  }
}
#include <stdio.h>
int main()
{
  char c[8];
  int n[10] = {0};
  int ans = 0;
  scanf("%s", c);
  for(int i = 0; c[i] != 0; i++)
    n[c[i] - 48]++;
  if(n[6] + n[9] >= 2)
  {
    n[6] += n[9];
    if(n[6] % 2)
      n[6] += 1;
    n[9] = (n[6] /= 2);
  }
  for(int i = 0; i < 10; i++)
  {
    if(ans < n[i])
      ans = n[i];
  }
  printf("%d", ans);
}
#include <stdio.h>
int is_pn(int k)
{
  for(int i = 2; i * i <= k; i++)
  {
    if(!(k % i))
      return (0);
  }
  return (k);
}

int main()
{
  int m, n;
  int ans1 = 0;
  int ans2 = 0;
  scanf("%d %d", &m, &n);
  if (m == 1)
    m++;
  while(m<=n)
  {
    if(!ans1 && is_pn(m))
      ans2 = is_pn(m);
    ans1 += is_pn(m);
    m++;
  }
  if(!ans1)
  {
    printf("-1");
    return (0);
  }
  printf("%d\n%d", ans1, ans2);
}
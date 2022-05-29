#include <stdio.h>
int main()
{
  int e, s, m, ans;
  ans = 1;
  scanf("%d %d %d", &e, &s, &m);
  while(!(e == 1 && s == 1 && m == 1))
  {
    e -= 1;
    s -= 1;
    m -= 1;
    if (!e)
      e = 15;
    if (!s)
      s = 28;
    if (!m)
      m = 19;
    ans += 1;
  }
  printf("%d", ans);
}
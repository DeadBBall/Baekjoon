#include <stdio.h>

int main()
{
  int a, b, v;
  int ans = 0;
  scanf("%d %d %d", &a, &b, &v);
  v -= a;
  ans++;
  ans += v / (a-b);
  if(v % (a-b))
    ans++;
  printf("%d", ans);
}
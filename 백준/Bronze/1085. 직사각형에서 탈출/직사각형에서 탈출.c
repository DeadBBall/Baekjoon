#include <stdio.h>

int main()
{
  int x, y, w, h;
  scanf("%d %d %d %d", &x, &y, &w, &h);
  int ans = 0;
  ans = x - 0;
  if(y - 0 < ans)
    ans = y - 0;
  if(w - x < ans)
    ans = w - x;
  if(h - y < ans)
    ans = h - y;
  printf("%d", ans);
}
#include <stdio.h>
int main()
{
  int n;
  int cnt = 0;
  scanf("%d", &n);
  while(n)
  {
    cnt += n%2;
    n/=2;
  }
  printf("%d", cnt);
}
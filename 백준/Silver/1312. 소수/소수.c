#include <stdio.h>
int main()
{
  int a;
  int b;
  int n;
  scanf("%d %d %d", &a, &b, &n);
  a = a % b * 10;
  for(int i = 1; i < n; i++)
  {
    a = a % b * 10;
  }
  printf("%d", a/b);
}
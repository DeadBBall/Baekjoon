#include <stdio.h>

int main()
{
  int n;
  scanf("%d", &n);
  int m[100];
  int fib0[41];
  int fib1[41];
  fib0[0] = 1;
  fib0[1] = 0;
  fib1[0] = 0;
  fib1[1] = 1;
  for(int i = 2; i < 41; i++)
  {
    fib0[i] = fib1[i-1];
    fib1[i] = fib0[i-1] + fib1[i-1];
  }
  for(int i = 0; i < n; i++)
    scanf("%d", &m[i]);
  for(int i = 0; i < n; i++)
    printf("%d %d\n", fib0[m[i]], fib1[m[i]]);
}
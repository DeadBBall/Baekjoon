#include <stdio.h>

int main()
{
  int a, b, tmp, tmp2, tmp3;
  scanf("%d %d", &a, &b);
  if (a < b)
    {
      tmp = a;
      a = b;
      b = tmp;
    }
    tmp = a;
    tmp2 = b;
  while(tmp2)
  {
    tmp3 = tmp % tmp2;
    tmp = tmp2;
    tmp2 = tmp3;
  }
  tmp2 = a * b / tmp;
  printf("%d\n%d", tmp, tmp2);
}
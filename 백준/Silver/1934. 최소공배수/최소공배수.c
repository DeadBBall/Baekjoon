#include <stdio.h>
void com(int a, int b)
{
  int tmp, tmp2, tmp3;
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
  printf("%d\n", tmp2);
}
int main()
{
  int n;
  scanf("%d", &n);
  int a[1000], b[1000];
  for(int i = 0; i < n; i++)
    scanf("%d %d", &a[i], &b[i]);
  for(int i = 0; i < n; i++)
    com(a[i], b[i]);
}
#include <stdio.h>

int main()
{
  int n[1000] = {0};
  for(int i = 0; ;i++)
  {
    int a, b, c, tmp;
    scanf("%d %d %d", &a, &b, &c);
    if(a > b && a > c)
    {
      tmp = a;
      a = c;
      c = tmp;
    }
    if(b > a && b >c)
    {
      tmp = b;
      b = c;
      c = tmp;
    }
    if(a * a + b * b == c * c)
      n[i] = 1;
    else
      n[i] = 0;
    if(!a)
    {
      n[i] = -1;
      break;
    }
  }
  for(int i = 0; n[i] != -1; i++)
  {
    if(n[i] == 1)
      printf("right\n");
    else
      printf("wrong\n");
  }
}
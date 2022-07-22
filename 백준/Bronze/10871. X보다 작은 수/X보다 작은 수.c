#include <stdio.h>
int main()
{
  int a[10001];
  int n, x;
  scanf("%d%d", &n, &x);
  for(int i = 0; i < n; i++)
  {
    int tmp;
    scanf("%d", &tmp);
    if(tmp < x)
      printf("%d ", tmp);
  }
}
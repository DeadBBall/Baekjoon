#include <stdio.h>

int main()
{
  int n, k;
  int a[1001];
  scanf("%d %d", &n, &k);
  for(int i = 0; i < n; i++)
    a[i] = i + 1;
  int tmp = 0;
  printf("<");
  while(n >= 1)
  {
    tmp += k - 1;
    while(tmp > n - 1)
      tmp -= n;
    printf("%d", a[tmp]);
    for(int i = tmp; i < n - 1; i++)
      a[i] = a[i + 1];
    n--;
    if(n)
      printf(", ");
  }
  printf(">");
}
#include <stdio.h>
int main()
{
  int n;
  int a[200];
  int b[50] = {0};
  scanf("%d", &n);
  for(int i = 0; i < 2 * n - 1; i += 2)
  {
    scanf("%d %d", &a[i], &a[i + 1]);
    b[i/2] = 1;
  }
  for(int i = 0; i < 2 * n - 1; i += 2)
  {
    for(int j = 0; j < 2 * n - 1; j += 2)
      {
        if(a[i] < a[j] && a[i+1] < a[j+1] && i != j)
          b[i/2]++;
      }
  }
  for(int i = 0; i < n; i++)
    printf("%d ", b[i]);
}
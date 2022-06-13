#include <stdio.h>
#include <stdlib.h>

typedef struct
{
  int x;
  int y;
} co;

int cmp(const void* a, const void* b)
{
  if(((co *)a)->y == ((co *)b)->y)
    return ((co *)a)->x - ((co *)b)->x;
  return((co *)a)->y - ((co *)b)->y;
}
int main()
{
  co c[100001];
  int n;
  scanf("%d", &n);
  for(int i = 0; i < n; i++)
    scanf("%d %d", &c[i].x, &c[i].y);
  qsort(c, n, sizeof(co), cmp);
  for(int i = 0; i < n; i++)
    printf("%d %d\n", c[i].x, c[i].y);
}
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct
{
  int x;
  char nm[101];
} coo;

int cmp(const void* a, const void* b)
{
  coo *co1 = (coo *)a;
  coo *co2 = (coo *)b;
  return co1->x - co2->x;
}

int main()
{
  int n;
  scanf("%d", &n);
  coo c[100001];
  for(int i = 0; i < n; i++)
    scanf("%d %s", &c[i].x, c[i].nm);
  qsort(c, n, sizeof(coo), cmp);
  for(int i = 0; i < n; i++)
    printf("%d %s\n", c[i].x, c[i].nm);
}
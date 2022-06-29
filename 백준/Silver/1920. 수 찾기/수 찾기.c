#include <stdio.h>
#include <stdlib.h>

int bin(int ans, int left, int right, int list[])
{
  if(left <= right)
  {
    int mid = (left + right) / 2;
    if(list[mid] == ans)
      return 1;
    else if(list[mid] > ans)
      return bin(ans, left, mid - 1, list);
    else
      return bin(ans, mid + 1, right, list);
  }
  return 0;
}
int cmp(const void* a, const void* b)
{
  return *(int*)a > *(int*)b ? 1 : 0;
}
int main()
{
  int a[100001];
  int n, m;
  scanf("%d", &n);
  for(int i = 0; i < n; i++)
    scanf("%d", &a[i]);
  qsort(a, n, sizeof(int), cmp);
  scanf("%d", &m);
  for(int i = 0; i < m; i++)
  {
    int tmp;
    scanf("%d", &tmp);
    printf("%d\n", bin(tmp, 0, n - 1, a));
  }
}
#include <stdio.h>
int main()
{
  int n, m;
  scanf("%d %d", &n, &m);
  int a[1000001];
  long long high;
  for(int i = 0; i < n; i++)
  {
    scanf("%d", &a[i]);
    high = a[0];
    if(a[i] > high)
      high = a[i];
  }
  int low = 0;
  long long mid;
  while(low <= high)
  {
    mid = (high + low) / 2;
    long long tmp = 0;
    for(int i = 0; i < n; i++)
    {
      if(a[i]> mid)
        tmp += a[i] - mid;
    }
    if(tmp >= m)
      low = mid + 1;
    else
      high = mid - 1;
  }
  printf("%d", (int)high);
}
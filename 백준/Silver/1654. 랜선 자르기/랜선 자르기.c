#include <stdio.h>

int main()
{
  int n, k;
  int a[20000];
  long long low = 1;
  long long sum = 0;
  scanf("%d %d", &k, &n);
  for(int i = 0; i < k; i++)
  {
    scanf("%d", &a[i]);
    sum += a[i];
  }
  long long high = sum / n;
  long long mid = 0;
  while(low <= high)
  {
    int tmp = 0;
    mid = (high + low) / 2;
    for(int j = 0; j < k; j++)
      tmp += a[j] / mid;
    if(tmp >= n)
      low = mid + 1;
    else
      high = mid - 1;
  }
  printf("%d", (int)high);
}
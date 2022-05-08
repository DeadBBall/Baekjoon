#include <stdio.h>

int main()
{
  int n;
  int max = 0;
  int min = 0;
  scanf("%d", &n);
  int arr[n];
 
  for(int i; i < n; i++)
  {
    scanf("%d", &arr[i]);
    if (!i)
    {
        max = arr[0];
        min = arr[0];
    }
    if (max < arr[i])
        max = arr[i];
    if (min > arr[i])
        min = arr[i];
  }
  printf("%d", max * min);
}
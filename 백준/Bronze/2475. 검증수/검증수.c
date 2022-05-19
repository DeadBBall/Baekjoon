#include <stdio.h>
int main()
{
  int arr[7];
  int n = 0;
  for(int i = 0; i < 5; i++)
  {  
    scanf("%d", &arr[i]);
    n =  n + arr[i] * arr[i];
  }
  n %= 10;
  printf("%d", n);
}
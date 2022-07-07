#include <stdio.h>
int main()
{
  char a[51];
  long long result = 0, r = 1;
  int L;
  scanf("%d %s", &L, a);
  for (int i = 0; i < L; i++)
  {
    result = (result + (a[i]-'a'+1) * r) % 1234567891;
    r = (r*31) % 1234567891;
  }
  printf("%lld", result);
}
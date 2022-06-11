#include <stdio.h>
struct coo
{
  int x;
  int y;
};

int main()
{
  struct coo n[200000];
  int m;
  scanf("%d", &m);
  for(int i = 0; i < m; i++)
    scanf("%d %d", &n[i].x, &n[i].y);
  for(int i = 1; i < m; i++)
  {
    int c = i;
    do
    {
      int root = (c - 1) / 2;
      if(n[root].x < n[c].x)
      {
        int tmp = n[root].x;
        n[root].x = n[c].x;
        n[c].x = tmp;
        tmp = n[root].y;
        n[root].y = n[c].y;
        n[c].y = tmp;
      }
      if(n[root].x == n[c].x && n[root].y < n[c].y)
      {
        int tmp = n[root].x;
        n[root].x = n[c].x;
        n[c].x = tmp;
        tmp = n[root].y;
        n[root].y = n[c].y;
        n[c].y = tmp;
      }
      c = root;
    } while (c != 0);
  }
  for(int i = m - 1; i >= 0; i--)
  {
    int tmp = n[0].x;
    n[0].x = n[i].x;
    n[i].x = tmp;
    tmp = n[0].y;
    n[0].y = n[i].y;
    n[i].y = tmp;
    int root = 0;
    int c = 1;
    do
    {
      c = 2 * root + 1;
      if((n[c].x < n[c + 1].x || (n[c].x == n[c + 1].x && n[c].y < n[c + 1].y)) && c < i - 1)
        c++;
      if((n[root].x < n[c].x || (n[root].x == n[c].x && n[root].y < n[c].y)) && c < i)
      {
       int tmp = n[root].x;
       n[root].x = n[c].x;
       n[c].x = tmp;
       tmp = n[root].y;
       n[root].y = n[c].y;
       n[c].y = tmp;
      }
      root = c;
    } while(c < i);
  }
  for(int i = 0; i < m; i++)
    printf("%d %d\n", n[i].x, n[i].y);
}
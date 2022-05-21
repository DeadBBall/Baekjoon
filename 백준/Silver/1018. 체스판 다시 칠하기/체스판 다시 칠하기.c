#include <stdio.h>
int ft_cmp(char b[8][9], char w[8][9], char d[52][52], int i, int j)
{
  int ans_w = 0;
  int ans_b = 0;
   for(int y = 0; y < 8; y++)
    {
      for(int x = 0; x < 8; x++)
      {
        if (b[y][x] != d[i+y][j+x])
          ans_b++;
        if (w[y][x] != d[i+y][j+x])
          ans_w++;
      }
    }
  return (ans_b > ans_w ? ans_w : ans_b);
}
int main()
{
    char d[52][52] ={0};
    char b[8][9] = {"BWBWBWBW",
                    "WBWBWBWB",
                    "BWBWBWBW",
                    "WBWBWBWB",
                    "BWBWBWBW",
                    "WBWBWBWB",
                    "BWBWBWBW",
                    "WBWBWBWB"};
    char w[8][9] = {"WBWBWBWB",
                    "BWBWBWBW",
                    "WBWBWBWB",
                    "BWBWBWBW",
                    "WBWBWBWB",
                    "BWBWBWBW",
                    "WBWBWBWB",
                    "BWBWBWBW"};
    int x, y;
    int ans = 0;
    scanf("%d %d\n", &y, &x);
    for(int i = 0; i < y; i++)
        scanf("%s", &d[i]);
    for(int i = 0; i+7 < y; i++)
    {
        for(int j = 0; j+7 < x; j++)
        {
          if (!i&&!j)
            ans = ft_cmp(b, w, d, i, j);
          else
            {
              if (ans > ft_cmp(b, w, d, i, j))
                ans = ft_cmp(b, w, d, i, j);
            }
        }
    }
    printf("%d", ans);
}
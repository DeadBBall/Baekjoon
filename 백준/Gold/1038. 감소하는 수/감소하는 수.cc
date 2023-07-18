#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, ans[11], cnt;
bool poss;

void input()
{
    cin >> n;
    poss = true;
}

bool checkNum()
{
    for(int idx = cnt - 1; idx >= 1; idx--)
    {
        if(ans[idx] <= ans[idx - 1])
        {
            return false;
        }
    }
    return true;
}

void searchNum()
{
    int idx = 0;
    cnt = 1;
    while(idx != n)
    {
        if(cnt == 11)
        {
            poss = false;
            break;
        }
        if(cnt == 1)
        {
            idx++;
            ans[0]++;
            if(ans[0] == 10)
            {
                ans[1] = 1;
                ans[0] = 0;
                cnt++;
            }
        }
        else
        {
            ans[0]++;
            while(!checkNum() && cnt != 11)
            {
                if(ans[0] >= ans[1])
                {
                    for(int i = 0; i < cnt - 1; i++)
                    {
                        if(ans[i + 1] <= ans[i])
                        {
                            ans[i] = 0;
                            ans[i + 1]++;
                        }
                    }
                    if(ans[cnt - 1] == 10)
                    {
                        ans[cnt] = 1;
                        ans[cnt - 1] = 0;
                        cnt++;
                    }
                }
            }
            idx++;
        }
        // for(int i = cnt - 1; i >= 0; i--)
        // {
        //     cout << ans[i];
        // }
        // cout << " " << cnt << "\n";
    }
    if(cnt == 11)
    {
        poss = false;
    }
}

int main()
{
    input();
    searchNum();
    if(poss)
    {
        for(int i = cnt - 1; i >= 0; i--)
        {
            cout << ans[i];
        }
    }
    else
    {
        cout << -1;
    }
}
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n, c, house[200001];
vector<int> diff;

void input()
{
    cin >> n >> c;
    for(int i = 0; i < n; i++)
    {
        cin >> house[i];
    }
    sort(house, house + n);
}

bool canInstall(int dist)
{
    int cnt = 1;
    int prev = house[0];
    for(int i = 1; i < n; i++)
    {
        if(house[i] - prev >= dist)
        {
            cnt++;
            prev = house[i];
        }
    }
    if(cnt >= c)
    {
        return true;
    }
    return false;
}

void installModem()
{
    int low = 1;
    int high = house[n - 1] - house[0] + 1;
    while(low < high)
    {
        int mid = (low + high) / 2;
        if(canInstall(mid))
        {
            low = mid + 1;
        }
        else
        {
            high = mid;
        }
    }
    cout << low - 1;
}

int main()
{
    input();
    installModem();
}
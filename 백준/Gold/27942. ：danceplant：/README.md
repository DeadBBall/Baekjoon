# [Gold V] :danceplant: - 27942 

[문제 링크](https://www.acmicpc.net/problem/27942) 

### 성능 요약

메모리: 439056 KB, 시간: 1584 ms

### 분류

구현, 누적 합, 시뮬레이션

### 제출 일자

2024년 7월 24일 16:45:22

### 문제 설명

<p style="text-align: center;"><img alt="" src="" style="max-width: min(100%,128px); height: auto;"></p>

<p style="text-align: center;"><small>춤추는 가지의 모습</small></p>

<p>흥이 넘치는 우리의 가지는 상하좌우로 몸을 늘이며 춤추는 것을 좋아한다. 춤을 추면 에너지가 소모되기 마련, 가지는 춤을 출 때 에너지를 보충할 수 있도록 주변에 섭취할 양분을 미리 준비해둔다. 가지는 매 순간 최대한의 양분을 섭취하며 열정적으로 춤을 추고 싶어 한다. 자신이 보여줄 수 있는 최고의 춤을 추고 싶어 하는 가지를 위해 어떻게 몸을 늘여야 할지 알려주자.</p>

<p>처음 가지는 $N \times N$ ($N$은 짝수) 격자의 정중앙 $2 \times 2$ 공간을 차지하고 있다. 즉 격자의 왼쪽 맨 위 칸의 좌표를 $(1, 1)$, 오른쪽 맨 아래 칸의 좌표를 $(N, N)$이라고 하면 가지가 차지하는 공간 왼쪽 맨 위 칸의 좌표는 $(\frac{N}{2}, \frac{N}{2})$, 오른쪽 맨 아래 칸의 좌표는 $(\frac{N}{2} + 1, \frac{N}{2} + 1)$이다.</p>

<p>매 순간 가지는 자신이 차지하는 공간의 평행한 두 변의 길이를 상하좌우 중 한 방향으로 $1$ 늘이고, 늘어난 공간에 위치한 양분을 전부 먹는다. 가지는 보여줄 수 있는 최고의 춤을 보여주고 싶기에 <strong>현재 </strong>가능한 많은 양분을 먹는 방향으로 몸을 늘인다. 만약 그러한 방향이 여럿이면 상하좌우 순으로 우선하여 몸을 늘인다. 만약 몸을 늘일 공간이 없거나 현재 먹을 수 있는 양분이 $0$ 이하라면 더이상 몸을 늘이지 않는다.</p>

### 입력 

 <p>첫째 줄에 $N$이 주어진다. $(4 \le N \le 3000;$ $N$은 짝수$)$</p>

<p>둘째 줄부터 $N$개 줄에 격자 위 양분의 정보가 주어진다. 각 양분의 값은 $-25$ 이상 $25$ 이하의 정수이고, 격자의 중앙 $2 \times 2$는 항상 $0$이다.</p>

### 출력 

 <p>첫째 줄에 가지가 몸을 늘이며 먹은 양분의 총량을 출력한다.</p>

<p>둘째 줄에 가지가 몸을 늘인 방향을 나타내는 문자를 늘인 순서대로 한 줄에 출력한다. 상하좌우는 각각 <span style="color:#e74c3c;"><code>UDLR</code></span>에 대응된다.</p>


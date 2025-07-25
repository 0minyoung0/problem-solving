# [Silver III] 도미노 게임 - 34053 

[문제 링크](https://www.acmicpc.net/problem/34053) 

### 성능 요약

메모리: 108472 KB, 시간: 512 ms

### 분류

그리디 알고리즘, 애드 혹

### 제출 일자

2025년 7월 20일 15:23:08

### 문제 설명

<p>$N\times M$ 크기의 격자가 주어진다. $i$행 $j$열의 칸에는 음이 아닌 정수 $a_{ij}$가 적혀 있다. ($1\le i\le N$; $1\le j\le M$)</p>

<p>민지는 각 차례마다 아래와 같은 행동을 한다.</p>

<ol>
	<li>격자에서 상하좌우로 인접한 두 칸을 선택한다. 이때 두 칸에 적힌 수 중 적어도 하나는 양의 정수이어야 한다.</li>
	<li>선택한 칸에 적힌 수에서 $1$씩 뺀다. 만약 어떤 칸에 적힌 수가 $0$이라면 그대로 둔다.</li>
</ol>

<p>모든 칸에 적힌 수가 $0$이 될 때 게임이 종료된다. 민지는 이 게임을 최대한 오래 하려고 한다. 민지가 최선을 다해 게임을 오래 진행했을 때, 진행할 수 있는 최대 차례의 수를 구해보자.</p>

### 입력 

 <p>첫째 줄에 양의 정수 $N$, $M$이 공백으로 구분되어 주어진다. ($2 \le N, M \le 1\,000$)</p>

<p>이후 $N$개의 줄에 걸쳐 격자에 적힌 수가 주어진다. 그 중 $i$번째 줄에는 $a_{i1}, a_{i2}, \cdots, a_{iM}$이 공백으로 구분되어 주어진다. ($0 \le a_{ij} \le 10^9$)</p>

### 출력 

 <p>진행할 수 있는 최대 차례의 수를 출력한다.</p>


# [Platinum III] 블록 게임 - 15706 

[문제 링크](https://www.acmicpc.net/problem/15706) 

### 성능 요약

메모리: 114476 KB, 시간: 776 ms

### 분류

자료 구조, 세그먼트 트리

### 제출 일자

2025년 2월 26일 14:27:23

### 문제 설명

<p>총 N개의 블록이 일렬로 놓여져 있다. 가장 왼쪽에 있는 블록의 번호는 1번이고, 그 오른쪽에 있는 블록은 2번이다. 이런식으로 가장 오른쪽에 있는 블록의 번호는 N번이다. i번 블록의 높이는 H<sub>i</sub>이다.</p>

<p>블록 게임을 하려면 블록의 앞에 작은 기계를 하나 놓아야 한다. 가장 처음에 이 기계는 1번 블록의 앞에 있다. 블록 게임의 목표는 기계를 이용해 블록을 <strong>모두</strong> 제거하는 것이다. 이때, 제거한 순서대로 블록의 높이를 나열한 수열은 비내림차순(non-descreasing order)을 만족해야 한다.</p>

<p>기계가 수행할 수 있는 명령은 다음과 같은 세 가지이다.</p>

<ul>
	<li>오른쪽 블록으로 이동한다. i번 블록 앞에 있었으면, i+1번 블록 앞으로 이동한다. 만약, 오른쪽에 블록이 없으면 이 명령을 내릴 수 없다.</li>
	<li>왼쪽 블록으로 이동한다. i번 블록 앞에 있었으면, i-1번 블록 앞으로 이동한다. 만약, 왼쪽에 블록이 없으면 이 명령을 내릴 수 없다.</li>
	<li>기계의 앞에 있는 블록을 제거하고, 왼쪽 또는 오른쪽 블록으로 이동한다. 제거한 후에 이동하는 방향도 정해서 이 명령을 내려야 한다. 블록을 모두 제거해 양쪽에 블록이 없는 경우에는 이동하지 않아도 된다.</li>
</ul>

<p>제거하는 명령을 내렸을 때, 블록의 번호가 변하게 된다. 예를 들어, 블록의 높이가 (2, 3, 4, 5, 6)이고, 기계가 현재 높이가 4인 블록 앞에 있는 경우가 있다. 높이가 4인 블록은 왼쪽에서부터 3번째에 있기 때문에, 3번이다. 이 블록을 제거하고 왼쪽으로 이동하면, 블록의 높이는 (2, 3, 5, 6)이 되고 블록은 높이가 3인 블록(2번 블록) 앞에 있게 된다. 만약, 오른쪽으로 이동하면, 블록의 높이는 (2, 3, 5, 6)이 되고 블록은 높이가 5인 블록(3번 블록) 앞에 있게 된다.</p>

<p>게임의 목표를 달성하기 위해 필요한 명령의 최소 횟수를 구하는 프로그램을 작성하시오. </p>

<p>길이가 K인 수열 A<sub>1</sub>, A<sub>2</sub>, ..., A<sub>K</sub>가 A<sub>1</sub> ≤ A<sub>2</sub> ≤ ... ≤ A<sub>K</sub>를 만족하면, 비내림차순(non-decreasing order)이라고 한다. </p>

### 입력 

 <p>첫째 줄에 블록의 개수 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄에는 블록의 높이 H<sub>i</sub>가 순서대로 주어진다. (1 ≤ H<sub>i</sub> ≤ 100,000)</p>

### 출력 

 <p>첫째 줄에 게임의 목표를 달성하기 위해 필요한 명령의 최소 횟수를 출력한다.</p>


# [Silver II] 배열 놀이 - 17123 

[문제 링크](https://www.acmicpc.net/problem/17123) 

### 성능 요약

메모리: 333076 KB, 시간: 1488 ms

### 분류

구현, 누적 합

### 제출 일자

2025년 3월 9일 15:31:46

### 문제 설명

<p>N개의 행과 N개의 열로 구성된 2차원 정수 배열 A가 있다. A[r, c]는 r번째 행 c번째 열에 위치한 원소의 값을 나타낸다.</p>

<p>이 배열에 총 M번의 연산을 적용하는 배열 놀이를 생각해보자.</p>

<p>각 연산에 대해  1 <= r1 <= r2 <= N, 1 <= c1 <= c2  <= N, -1,000 <= v <= 1,000을 만족하는 다섯 개의 정수 파라미터 (r1, c1, r2, c2, v)가 주어지는데, 이 연산은 (r1, c1)부터 (r2, c2)까지 사각형 영역에 속한 A[r, c]의 값을 v만큼 더하는 것이다.</p>

<p>예를 들어 N = 3 그리고 A = [ [ 1 2 3 ] [ 4 5 6 ] [ 7 8 9 ] ] 인 2차원 배열을 생각해보자. 아래와 같은 3개의 연산을 순서대로 적용한다고 하자.</p>

<ul>
	<li>연산 1: (r1 = 1, c1 = 1, r2 = 2, c2 = 3, v = 3)</li>
	<li>연산 2: (r1 = 2, c1 = 2, r2 = 3, c2 = 2, v = -5)</li>
	<li>연산 3: (r1 = 1, c1 = 1, r2 = 3, c2 = 2, v = 1)</li>
</ul>

<p>연산을 적용하기 전 A는 아래와 같다.</p>

<pre>A = [ [ 1 2 3 ]
      [ 4 5 6 ]
      [ 7 8 9 ] ].</pre>

<p>연산 1을 적용하면 첫 두 행에 포함된 여섯 개의 원소 값이 바뀌게 되어 아래와 같아진다 (굵게 표시된 수들의 값이 바뀌었다):</p>

<pre>A = [ [ <strong>4 5 6</strong> ]
      [ <strong>7 8 9</strong> ]
      [ 7 8 9 ] ].</pre>

<p>연산 2를 적용한 후:</p>

<pre>A = [ [ 4 5 6 ]
      [ 7 <strong>3</strong> 9 ]
      [ 7 <strong>3</strong> 9 ] ].</pre>

<p>연산 3을 적용한 후:</p>

<pre>A = [ [ <strong>5 6</strong> 6 ]
      [ <strong>8 4</strong> 9 ]
      [ <strong>8 4</strong> 9 ] ].</pre>

<p>이렇게 총 3개의 연산을 모두 적용하고 난 후, 당신은 마지막에 얻은 배열의 각 행의 원소들의 합과 각 열의 원소들의 합을 구하고 싶다. 위의 예제의 경우, 행의 원소들의 합은 [17, 21, 21] 이며 (1번 행 부터 3번 행까지) 열의 원소들의 합은 [21, 14, 24] 이다 (1번 열 부터 3번 열 까지).</p>

<p>입력으로 N, M, 2차원 배열 A, 그리고 M개의 연산이 주어졌을 때, 배열에 연산을 모두 적용한 후 해당 배열의 행의 원소들의 합과 열의 원소들의 합을 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫 줄에 테스트 케이스의 수 T가 주어진다 (1 <= T <= 10).</p>

<p>각 테스트 케이스에 대하여: 첫 줄에 두 개의 정수 N과 M이 공백으로 구분되어 주어진다 (1 <= N <= 1,000 과 1 <= M <= 1,000 을 만족한다).</p>

<p>다음 N줄에 걸쳐서 2차원 배열 A가 주어지는데, i-번째 줄이 i-번째 행을 나타낸다. 각 줄의 j번째 정수는 j-번째 열의 원소 값을 나타낸다. 배열 A의 각 원소의 값은 1이상 1,000 이하의 정수이다.</p>

<p>다음 M줄에 걸쳐서 각 줄에 다섯 개의 정수 r1, c1, r2, c2, v가 공백으로 구분되어 주어진다. 항상 1 <= r1 <= r2 <= N 그리고 1 <= c1 <= c2 <= N 그리고 -1,000 <= v <= 1,000 을 만족한다. </p>

### 출력 

 <p>각 테스트 케이스에 대해 두 줄에 걸쳐서 정답을 출력해야 한다.</p>

<p>두 줄 중 첫 줄에는 N개의 정수로 표현된 각 행의 합을 공백으로 구분하여 출력하고 (1번 행 부터 N번 행 까지)</p>

<p>둘째 줄에는 N개의 정수로 표현된 각 열의 합을 공백으로 구분하여 출력한다 (1번 열 부터 N번 열 까지).</p>


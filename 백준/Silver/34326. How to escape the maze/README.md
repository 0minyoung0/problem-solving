# [Silver II] How to escape the maze - 34326 

[문제 링크](https://www.acmicpc.net/problem/34326) 

### 성능 요약

메모리: 53296 KB, 시간: 388 ms

### 분류

구현, 그래프 이론, 그래프 탐색, 시뮬레이션, 격자 그래프

### 제출 일자

2025년 9월 25일 21:05:19

### 문제 설명

<p>우연이는 수업 시간에 멍하니 있다가, 현실 세계에서 미로에 갇히면 어떻게 해야 확실하게 탈출할 수 있을지 문득 궁금해졌다.</p>

<p>수업이 끝난 후, 그는 그 방법을 인터넷에서 찾아보다가 좌수법이라는 기법을 알게 되었다. 깨달음을 얻은 우연이는 옆에 앉아 있던 보경이에게 "좌수법을 쓰면 미로를 무조건 탈출할 수 있다."라고 말했다. 하지만 보경이는 이미 그 방법을 알고 있었고, 직접 사용해 본 결과 좌수법보다 우수법이 더 낫다고 주장했다.</p>

<p><mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"> <mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N$</span></mjx-container>개의 행과 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D440 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>M</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$M$</span></mjx-container>개의 열로 이루어진 격자 모양의 미로가 주어진다. 미로의 칸은 빈칸, 벽, 입구, 출구 중 하나의 상태를 갖는다. <strong>입구에서의 시선은 가장 가까운 빈칸을 향한다</strong>.</p>

<p>좌수법과 우수법은 다음의 세 가지 행동을 조합하여 수행할 수 있다.</p>

<ul>
	<li>좌회전: 시선을 반시계 방향으로 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-msup><mjx-mn class="mjx-n"><mjx-c class="mjx-c39"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn><mjx-script style="vertical-align: 0.393em;"><mjx-mo class="mjx-n" size="s"><mjx-c class="mjx-c2218"></mjx-c></mjx-mo></mjx-script></mjx-msup></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><msup><mn>90</mn><mo>∘</mo></msup></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$90^\circ$</span></mjx-container> 회전한다.</li>
	<li>우회전: 시선을 시계 방향으로 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-msup><mjx-mn class="mjx-n"><mjx-c class="mjx-c39"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn><mjx-script style="vertical-align: 0.393em;"><mjx-mo class="mjx-n" size="s"><mjx-c class="mjx-c2218"></mjx-c></mjx-mo></mjx-script></mjx-msup></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><msup><mn>90</mn><mo>∘</mo></msup></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$90^\circ$</span></mjx-container> 회전한다.</li>
	<li>전진: 시선 방향으로 한 칸 이동한다. 단, 이동할 칸에 벽이 있다면 전진할 수 없다.</li>
</ul>

<p>좌수법의 경우 아래 의사 코드를 따라 움직인다.</p>

<pre>while 도착 지점에 도착하지 않음 :
    좌회전한다
    while 전진 할 수 없음 :
        우회전한다
    전진한다</pre>

<p>우수법의 경우 아래 의사 코드를 따라 움직인다.</p>

<pre>while 도착 지점에 도착하지 않음 :
    우회전한다
    while 전진 할 수 없음 :
        좌회전한다
    전진한다</pre>

<p>보경이의 자신만만한 말투에 괜히 기분이 상한 우연이는 좌수법이 더 우수한 방법이라며 맞섰고, 결국 둘은 어떤 방법이 더 좋은지를 직접 프로그램으로 구현해 확인해 보기로 했다.</p>

### 입력 

 <p>첫째 줄에 두 정수 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N$</span></mjx-container>, <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D440 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>M</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$M$</span></mjx-container>가 공백으로 구분되어 주어진다. <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mo class="mjx-n"><mjx-c class="mjx-c28"></mjx-c></mjx-mo><mjx-mn class="mjx-n"><mjx-c class="mjx-c33"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="4"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c2C"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="2"><mjx-c class="mjx-c1D440 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="4"><mjx-c class="mjx-c31"></mjx-c></mjx-mn><mjx-mstyle><mjx-mspace style="width: 0.167em;"></mjx-mspace></mjx-mstyle><mjx-mn class="mjx-n"><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn><mjx-mo class="mjx-n"><mjx-c class="mjx-c29"></mjx-c></mjx-mo></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mo stretchy="false">(</mo><mn>3</mn><mo>≤</mo><mi>N</mi><mo>,</mo><mi>M</mi><mo>≤</mo><mn>1</mn><mstyle scriptlevel="0"><mspace width="0.167em"></mspace></mstyle><mn>000</mn><mo stretchy="false">)</mo></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$(3 \le N, M \le 1\,000)$</span> </mjx-container></p>

<p>이어서 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N$</span></mjx-container>개의 줄에 걸쳐 길이 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D440 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>M</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$M$</span></mjx-container>의 문자열이 주어진다. <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D456 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-c2B"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="3"><mjx-c class="mjx-c31"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>i</mi><mo>+</mo><mn>1</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$i+1$</span></mjx-container>번째 줄의 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D457 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>j</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$j$</span></mjx-container>번째 문자는 위에서 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D456 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>i</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$i$</span></mjx-container>번째 행과 왼쪽에서 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D457 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>j</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$j$</span></mjx-container>번째 열이 교차하는 칸의 상태를 나타낸다.</p>

<p><code><span style="color:#e74c3c;">.</span></code>은 빈칸, <code><span style="color:#e74c3c;">*</span></code>은 벽, <code><span style="color:#e74c3c;">S</span></code>는 입구, <code><span style="color:#e74c3c;">E</span></code>는 출구를 의미한다.</p>

<p>두 지점 <code><span style="color:#e74c3c;">S</span></code>와 <code><span style="color:#e74c3c;">E</span></code>는 입력 전체에 각각 한 번씩 등장하고, 좌우상하 어떤 방향으로도 인접하지 않으며, 미로의 가장자리에 위치한다. 가장자리에 빈칸 <code><span style="color:#e74c3c;">.</span></code>은 위치하지 않는다.</p>

<p>탈출이 가능한 경우만 주어진다.</p>

### 출력 

 <p>좌수법을 사용할 경우 먼저 탈출이 가능하다면 <code><span style="color:#e74c3c;">LEFT IS BEST</span></code>를, 우수법을 사용할 경우 먼저 탈출이 가능하다면 <code><span style="color:#e74c3c;">RIGHT IS BEST</span></code>를 출력한다.</p>

<p>어느 방법을 써도 동일한 최단 시간에 탈출이 가능할 경우 <code><span style="color:#e74c3c;">SAME</span></code>을 출력한다.</p>


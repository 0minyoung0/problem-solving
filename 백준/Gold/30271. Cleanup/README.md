# [Gold V] Cleanup - 30271 

[문제 링크](https://www.acmicpc.net/problem/30271) 

### 성능 요약

메모리: 2028 KB, 시간: 0 ms

### 분류

다이나믹 프로그래밍

### 문제 설명

<p>Often, it takes a long time (months or even years) to clean up after a major hurricane<sup>1</sup>. There usually is a large amount of mud and debris, and contaminants (see the previous problem) can complicate the efforts further. Here, you will help the cleanup crew plan how to clean up debris along one road.</p>

<p>Cleaning up involves using a bulldozer to move the debris into a few big piles; from the piles, it will then be loaded onto trucks. Picking up any one pile of debris with the truck (regardless of how much debris gets loaded on it) takes an amount T of time; that’s because for each pile, the driver has to do a lot of paperwork, and by comparison, the time to drive there or load the pile is nothing.</p>

<p>The piles are created by moving debris with a bulldozer. You will be given how much debris starts where, and will need to decide where to move it to. (You could of course not move any debris, but then, each original pile will have to be picked up separately, which may not be optimal.) Moving u units of debris a distance of d with the bulldozer takes time u · d. Given the amount of debris at each location, you are to calculate the minimum total amount of time for moving the debris into piles, then using the truck to pick up those piles. The truck only starts driving once the bulldozer is done.</p>

<hr>
<p><sup>1</sup>not a small one like ours</p>

### 입력 

 <p>The first line contains a number 1 ≤ K ≤ 100, which is the number of input data sets in the file. This is followed by K data sets of the following form:</p>

<p>The first line of the data set contains two integers n, T, with 1 ≤ n ≤ 200 the number of original debris locations, and 0 ≤ T ≤ 1000000 the time that one trip by the truck takes.</p>

<p>This is followed by a line with 2n integers ℓ<sub>i</sub>, d<sub>i</sub>. Here, 0 ≤ ℓ<sub>i</sub> ≤ 1000000 is the location along the road of the i-th debris collection to be cleaned up, and 1 ≤ d<sub>i</sub> ≤ 1000000 gives the amount of debris at this place. The pairs will be sorted by (strictly) increasing ℓ<sub>i</sub>.</p>

### 출력 

 <p>For each data set, first output “Data Set x:” on a line by itself, where x is its number. Then, output the minimum amount of time the cleanup of the road can take (combined bulldozer and truck time).</p>

<p>Each data set should be followed by a blank line.</p>


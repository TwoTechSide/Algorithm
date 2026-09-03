# [level 0] [PCCE 기출문제] 4번 / 저축 - 250130 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/250130) 

### 성능 요약

메모리: 4.95 MB, 시간: 2.18 ms

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2026년 09월 03일 21:03:46

### 문제 설명

<p>진우는 돈을 모으기 위해 저축을 하려고 합니다. 목표로 하는 금액은 100만 원이며, 첫 달에 일정 금액을 넣은 뒤 70만 원까지는 매월 조금씩 저축하다가 70만 원 이후부터는 월 저축량을 늘려 빠르게 목표 금액을 달성하고자 합니다.</p>

<p>첫 달에 저축하는 금액을 나타내는 정수 <code>start</code>, 두 번째 달 부터 70만 원 이상 모일 때까지 매월 저축하는 금액을 나타내는 정수 <code>before</code>, 100만 원 이상 모일 때 까지 매월 저축하는 금액을 나타내는 정수 <code>after</code>가 주어질 때, 100만 원 이상을 모을 때까지 걸리는 개월 수를 출력하도록 빈칸을 채워 코드를 완성해 주세요.</p>

<hr>

<h4>제한사항</h4>

<ul>
<li>0 ≤ <code>start</code> ≤ 99</li>
<li>1 ≤ <code>before</code> ≤ <code>after</code> ≤ 25</li>
</ul>

<hr>

<h4>입출력 예</h4>

<p>입력 #1</p>
<div class="highlight"><pre class="codehilite"><code>28
6
8
</code></pre></div>
<p>출력 #1</p>
<div class="highlight"><pre class="codehilite"><code>12
</code></pre></div>
<p>입력 #2</p>
<div class="highlight"><pre class="codehilite"><code>75
8
25
</code></pre></div>
<p>출력 #2</p>
<div class="highlight"><pre class="codehilite"><code>2
</code></pre></div>
<hr>

<h4>입출력 예 설명</h4>

<p>입출력 예 #1</p>

<ul>
<li>매월 저축된 금액은 아래 표와 같습니다. 따라서 12를 출력합니다.</li>
</ul>
<table class="table">
        <thead><tr>
<th>1</th>
<th>2</th>
<th>3</th>
<th>4</th>
<th>5</th>
<th>6</th>
<th>7</th>
<th>8</th>
<th>9</th>
<th>10</th>
<th>11</th>
<th>12</th>
</tr>
</thead>
        <tbody><tr>
<td>28</td>
<td>34</td>
<td>40</td>
<td>46</td>
<td>52</td>
<td>58</td>
<td>64</td>
<td>70</td>
<td>78</td>
<td>86</td>
<td>94</td>
<td>102</td>
</tr>
</tbody>
      </table>
<p>입출력 예 #2</p>

<ul>
<li>첫 달 저축된 금액이 70이 넘으므로 두 번째 달부터 바로 <code>after</code>= 25 만큼 저축합니다. 따라서 2를 출력합니다. </li>
</ul>
<table class="table">
        <thead><tr>
<th>1</th>
<th>2</th>
</tr>
</thead>
        <tbody><tr>
<td>75</td>
<td>100</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
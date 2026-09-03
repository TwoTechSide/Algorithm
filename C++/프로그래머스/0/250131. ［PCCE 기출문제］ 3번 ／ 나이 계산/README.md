# [level 0] [PCCE 기출문제] 3번 / 나이 계산 - 250131 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/250131) 

### 성능 요약

메모리: 4.7 MB, 시간: 2.36 ms

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2026년 09월 04일 00:24:17

### 문제 설명

<p>나이를 세는 방법은 여러 가지가 있습니다. 그중 한국식 나이는 태어난 순간 1살이 되며 해가 바뀔 때마다 1살씩 더 먹게 됩니다. 연 나이는 태어난 순간 0살이며 해가 바뀔 때마다 1살씩 더 먹게 됩니다. 각각 나이의 계산법은 다음과 같습니다.</p>

<p>한국식 나이 : 현재 연도 - 출생 연도 + 1<br>
연 나이 : 현재 연도 - 출생 연도</p>

<p>출생 연도를 나타내는 정수 <code>year</code>와 구하려는 나이의 종류를 나타내는 문자열 <code>age_type</code>이 주어질 때 2030년에 몇 살인지 출력하도록 빈칸을 채워 코드를 완성해 주세요. <code>age_type</code>이 "Korea"라면 한국식 나이를, "Year"라면 연 나이를 출력합니다.</p>

<hr>

<h4>제한사항</h4>

<ul>
<li>1950 ≤ <code>year</code> ≤ 2030</li>
<li><code>age_type</code>은 "Korea" 또는 "Year"만 주어집니다.</li>
</ul>

<hr>

<h4>입출력 예</h4>

<p>입력 #1</p>
<div class="highlight"><pre class="codehilite"><code>2000
Korea
</code></pre></div>
<p>출력 #1</p>
<div class="highlight"><pre class="codehilite"><code>31
</code></pre></div>
<p>입력 #2</p>
<div class="highlight"><pre class="codehilite"><code>1999
Year
</code></pre></div>
<p>출력 #2</p>
<div class="highlight"><pre class="codehilite"><code>31
</code></pre></div>
<hr>

<h4>입출력 예 설명</h4>

<p>입출력 예 #1</p>

<ul>
<li>2030년에 2000년생의 한국식 나이는 2030 - 2000 + 1 = 31살입니다.</li>
</ul>

<p>입출력 예 #2</p>

<ul>
<li>2030년에 1999년생의 연 나이는 2030 - 1999 = 31살입니다.</li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
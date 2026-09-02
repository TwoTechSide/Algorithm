# [level 0] [PCCE 기출문제] 5번 / 산책 - 250129 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/250129) 

### 성능 요약

메모리: 4.82 MB, 시간: 0.01 ms

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2026년 09월 03일 01:30:04

### 문제 설명

<p>여름이는 강아지를 산책시키려고 합니다. 여름이는 2차원 좌표평면에서 동/서/남/북 방향으로 1m 단위로 이동하면서 강아지를 산책시킵니다. 산책루트가 담긴 문자열 <code>route</code>가 주어질 때, 도착점의 위치를 return하도록 빈칸을 채워 solution함수를 완성해 주세요.</p>

<ul>
<li><code>route</code>는 "N", "S", "E", "W"로 이루어져 있습니다.

<ul>
<li>"N"은 북쪽으로 1만큼 움직입니다.</li>
<li>"S"는 남쪽으로 1만큼 움직입니다.

<ul>
<li>북쪽으로 -1만큼 움직인 것과 같습니다.</li>
</ul></li>
<li>"E"는 동쪽으로 1만큼 움직입니다.</li>
<li>"W"는 서쪽으로 1만큼 움직입니다.

<ul>
<li>동쪽으로 -1만큼 움직인 것과 같습니다.</li>
</ul></li>
</ul></li>
<li>출발점으로부터 <code>[동쪽으로 떨어진 거리, 북쪽으로 떨어진 거리]</code>형태로 강아지의 최종 위치를 구해서 return해야 합니다.</li>
<li>출발점을 기준으로 서쪽, 남쪽에 있는 경우는 동쪽, 북쪽으로 음수만큼 떨어진 것으로 표현합니다.

<ul>
<li> 출발점으로부터 동쪽으로 2, 북쪽으로 3만큼 떨어졌다면 [2, 3]을 return 합니다.</li>
<li> 출발점으로부터 서쪽으로 1, 남쪽으로 4만큼 떨어졌다면 [-1, -4]를 return 합니다.</li>
</ul></li>
</ul>

<hr>

<h4>제한사항</h4>

<ul>
<li>1 ≤ <code>route</code>의 길이 ≤ 20</li>
<li><code>route</code>는 "N", "S", "E", "W"로만 이루어져 있습니다.</li>
</ul>

<hr>

<h4>입출력 예</h4>
<table class="table">
        <thead><tr>
<th>route</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>"NSSNEWWN"</td>
<td>[-1, 1]</td>
</tr>
<tr>
<td>"EESEEWNWSNWWNS"</td>
<td>[0, 0]</td>
</tr>
</tbody>
      </table>
<hr>

<h4>입출력 예 설명</h4>

<p>입출력 예 #1</p>

<ul>
<li>"NSSNEWWN" 순서대로 움직이면 서쪽으로 1, 북쪽으로 1만큼 떨어진 곳에 도착하게 되므로 [-1, 1]을 return합니다.</li>
</ul>

<p>입출력 예 #2</p>

<ul>
<li>"EESEEWNWSNWWNS" 순서대로 움직이면 출발지와 같은 곳으로 돌아오므로 [0, 0]을 return합니다.</li>
</ul>

<hr>

<ul>
<li>cpp를 응시하는 경우 리스트는 배열과 동일한 의미이니 풀이에 참고해주세요.

<ul>
<li>ex) 번호가 담긴 정수 <u><strong>리스트</strong></u> <code>numbers</code>가 주어집니다. =&gt; 번호가 담긴 정수 <u><strong>배열</strong></u> <code>numbers</code>가 주어집니다.</li>
</ul></li>
<li>java를 응시하는 경우 리스트는 배열, 함수는 메소드와 동일한 의미이니 풀이에 참고해주세요.

<ul>
<li>ex) solution <u><strong>함수</strong></u>가 올바르게 작동하도록 한 줄을 수정해 주세요. =&gt; solution <u><strong>메소드</strong></u>가 올바르게 작동하도록 한 줄을 수정해 주세요.</li>
</ul></li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
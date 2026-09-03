# [level 0] [PCCE 기출문제] 7번 / 가습기 - 250127 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/250127) 

### 성능 요약

메모리: 4.82 MB, 시간: 0.01 ms

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2026년 09월 04일 00:37:37

### 문제 설명

<p>상우가 사용하는 가습기에는 "auto", "target", "minimum"의 세 가지 모드가 있습니다. 가습기의 가습량은 0~5단계로 구분되며 각 모드 별 동작 방식은 다음과 같습니다.</p>

<ul>
<li><p>"auto" 모드</p>

<ul>
<li>습도가 0 이상 10 미만인 경우 : 5단계</li>
<li>습도가 10 이상 20 미만인 경우 : 4단계</li>
<li>습도가 20 이상 30 미만인 경우 : 3단계</li>
<li>습도가 30 이상 40 미만인 경우 : 2단계</li>
<li>습도가 40 이상 50 미만인 경우 : 1단계</li>
<li>습도가 50 이상인 경우 : 0단계</li>
</ul></li>
<li><p>"target" 모드</p>

<ul>
<li>습도가 설정값 미만일 경우 : 3단계</li>
<li>습도가 설정값 이상일 경우 : 1단계</li>
</ul></li>
<li><p>"minimum"모드</p>

<ul>
<li>습도가 설정값 미만일 경우 : 1단계</li>
<li>습도가 설정값 이상일 경우 : 0단계</li>
</ul></li>
</ul>

<p>상우가 설정한 가습기의 모드를 나타낸 문자열 <code>mode_type</code>, 현재 공기 중 습도를 나타낸 정수 <code>humidity</code>, 설정값을 나타낸 정수 <code>val_set</code>이 주어질 때 현재 가습기가 몇 단계로 작동 중인지 return하도록 빈칸을 채워 solution 함수를 완성해 주세요.</p>

<hr>

<h4>제한사항</h4>

<ul>
<li><code>mode_type</code>은 "auto", "target", "minimum" 세 가지 중 하나의 값을 갖습니다.</li>
<li>0 ≤ <code>humidity</code>, <code>val_set</code> ≤ 100</li>
</ul>

<hr>

<h4>입출력 예</h4>
<table class="table">
        <thead><tr>
<th>mode_type</th>
<th>humidity</th>
<th>val_set</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>"auto"</td>
<td>23</td>
<td>45</td>
<td>3</td>
</tr>
<tr>
<td>"target"</td>
<td>41</td>
<td>40</td>
<td>1</td>
</tr>
<tr>
<td>"minimum"</td>
<td>10</td>
<td>34</td>
<td>1</td>
</tr>
</tbody>
      </table>
<hr>

<h4>입출력 예 설명</h4>

<p>입출력 예 #1</p>

<ul>
<li>"auto"모드이므로 습도에 따라 가습량이 조절됩니다. 현재 습도가 20 이상 30 미만이므로 3을 return합니다.</li>
</ul>

<p>입출력 예 #2</p>

<ul>
<li>"target"모드이고, 설정값보다 습도가 높으므로 1을 return합니다.</li>
</ul>

<p>입출력 예 #3</p>

<ul>
<li>"minimum"모드이고, 설정값보다 습도가 낮으므로 1을 return합니다.</li>
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
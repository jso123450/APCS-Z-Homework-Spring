# Homework 08b - Linked Lists

Run Driver

<ul>
	<li>Tests LList methods to ensure functionality</li>
	<li>Runs time tests</li>
</ul>

<table class="tg">
  <tr>
    <th class="tg-hgcj"><center>Summing Lists of Length</center></th>
    <th class="tg-c9cr">ArrayList</th>
    <th class="tg-c9cr">LList</th>
    <th class="tg-c9cr">LinkedList</th>
  </tr>
  <tr>
    <td class="tg-30rh">1000</td>
    <td class="tg-s6z2">0</td>
    <td class="tg-s6z2">1</td>
    <td class="tg-s6z2">1</td>
  </tr>
  <tr>
    <td class="tg-30rh">10000</td>
    <td class="tg-s6z2">1</td>
    <td class="tg-s6z2">57</td>
    <td class="tg-s6z2">31</td>
  </tr>
  <tr>
    <td class="tg-30rh">100000</td>
    <td class="tg-s6z2">1</td>
    <td class="tg-s6z2">5716</td>
    <td class="tg-s6z2">4593</td>
  </tr>
</table>

Not completely sure why the results are what they are...

<br>

The ArrayList sum is always very fast.

<br>

The LList sum uses a loop within a loop (the loop used in LLsum() from TimeTest.java & the loop in get(int i) from LList.java)

<br>

The LinkedList sum should also be using a similar method; perhaps there was a more efficient way to reduce runtime speed than what I have here.

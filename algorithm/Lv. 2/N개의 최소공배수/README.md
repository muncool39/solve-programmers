## 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/12953

## 메모

최대 공약수
```java
private static int getGCD(int num1, int num2) {
  if (num1 % num2 == 0) return num2;
  return getGCD(num2, num1%num2);
}
```
최소 공배수
```java
private static int getLCM(int num1, int num2) {
  return (num1*num2)/getGCD(num1, num2);
}
```
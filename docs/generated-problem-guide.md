# Generated Problem Guide

## 목적

사용자가 이미 학습한 코딩테스트 문제를 바탕으로, 같은 알고리즘 사고와 핵심 풀이 패턴을 연습할 수 있는 새로운 문제를 생성합니다.

## 생성 위치

문제 생성 요청이 오면 원본 문제 디렉터리 안에 새 연습 문제 제목을 기반으로 하위 디렉터리를 생성합니다.
원본 문제 디렉터리는 사용자가 언급한 문제의 실제 풀이 파일이 있는 위치를 기준으로 합니다.

예시:

```text
src/programmers/kit/greedy/단속카메라/
├── Solution.java
└── 고속도로_임시_검문소/
    ├── problem.md
    └── Solution.java
```

새 연습 문제 디렉터리 이름은 문제 제목을 기반으로 작성하되(기본 한글, 필요시 영어), 공백은 `_`로 변환합니다.
원본 문제 디렉터리를 명확히 찾을 수 없을 때만 사용자에게 위치를 질문합니다.

## 생성 파일

생성 문제 디렉터리 안에는 반드시 아래 두 파일을 생성합니다.

```text
problem.md
Solution.java
```

## problem.md 작성 기준

`problem.md`에는 문제 내용만 작성합니다.

반드시 아래 형식을 지킵니다.
0. 원본 문제
1. 문제 설명
2. 제한사항
3. 입출력 예
4. 입출력 예 설명

정답 코드, 풀이 과정, 힌트, 알고리즘 설명은 사용자가 요청하기 전까지 작성하지 않습니다.

## Solution.java 작성 기준

`Solution.java`에는 사용자가 직접 풀이를 작성할 수 있도록 뼈대 코드만 작성합니다.

* 클래스명은 `Solution`으로 작성합니다.
* 파일 맨 위에 실제 디렉터리 경로에 맞는 Java `package` 선언을 작성합니다.
* 함수명은 `solution`으로 작성합니다.
* 매개변수와 반환 타입은 문제에 맞게 정합니다.
* 함수 내부에는 정답 로직을 작성하지 않습니다.
* 기본 반환값만 넣어 컴파일 가능한 형태로 작성합니다.
* `main` 함수를 함께 작성하여 `problem.md`의 입출력 예를 바로 실행해볼 수 있게 합니다.
* `main` 함수에서는 콘솔 입력을 받지 않고, 테스트 케이스를 코드에 직접 작성합니다.
* 각 테스트 케이스는 `solution` 호출 결과와 기대값을 함께 출력합니다.
* 불필요한 `import java.util.*;`는 작성하지 않습니다.

예시:

```java
package programmers.kit.greedy.단속카메라.고속도로_임시_검문소;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, 1, 4, new int[][]{{0, 1}, {1, 2}, {2, 3}}, 3);
        runTest(solution, 2, 5, new int[][]{{0, 2}, {2, 4}}, 2);
    }

    private static void runTest(Solution solution, int testNumber, int n, int[][] costs, int expected) {
        int result = solution.solution(n, costs);
        System.out.println("[test" + testNumber + "] result: " + result + " / expected: " + expected);
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;
        return answer;
    }
}
```

문제에 따라 반환 타입이 `String`, `int[]`, `boolean`, `long` 등이 될 수 있으며, 그에 맞는 기본 반환값을 작성합니다.
반환 타입이 배열인 경우에는 `Arrays.toString` 또는 `Arrays.deepToString`을 사용하여 결과와 기대값을 비교하기 쉽게 출력합니다.

## 문제 생성 기준

* 기존 문제와 완전히 동일한 코드로 풀리는 문제를 만들지 않습니다.
* 기존 문제의 핵심 알고리즘 사고와 풀이 패턴은 유지합니다.
* 문제 설정, 입력 형태, 조건 중 일부는 기존 문제와 다르게 만듭니다.
* 난이도는 기존 문제와 비슷하게 맞춥니다.
* 프로그래머스에서 풀 수 있는 형태처럼 작성합니다.
* 문제는 실제 코딩테스트에 나올 법한 자연스러운 상황으로 만듭니다.
* 생성 기준이 충분하면 추가 선택지를 묻지 말고 바로 생성합니다. 
* 모호함이 실제로 결과에 큰 영향을 줄 때만 질문합니다.

package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
    문제가 스택/ 큐 카테고리에 안에 있어서 최대한 두 자료구조를 활용했음
 */

public class ffdev_funcDevelope {

    public static void main(String[] args) {

        // 테스트용 더미 데이터
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        solution(progresses, speeds);

    }

    public static List<Integer> solution(int[] progresses, int[] speeds) {

        List<Integer> answer = new ArrayList<>();

        /*
            100 에서 현재 진행상황을 뺀 다음 속도로 나눈 값이 일을 완료할때 까지 걸리는 시간이다.
            이떄 나머지가 생기면 날짜 +1을 해줘야 하므로 소숫점이 있을시 올림으로 처리하기 위해
            Double 형 자료구조와 Math.ceil을 사용해서 큐에는 각 작업별 걸리는 시간을 추가
        */

        double[] temp = new double[progresses.length];

        Queue<Double> queue = new LinkedList<>();

        for (int i = 0; i < temp.length; i++) {

            queue.offer(Math.ceil((double) (100 - progresses[i]) / speeds[i]));
        }

        // 큐안에 값이 제대로 들어갔나 판별용
        for (double i : queue) {
            System.out.println("i = " + i);
        }

        /*
            큐.poll 을 하면 front의 값을 제거하고 그 값을 반환하며 큐.peek를 하면 값을 삭제하지 않고 front의 값을 반환하는 특징을 사용.
            최초 큐의 front값을 current
            처리한 작업을 세는 변수 cnt
            현재 비교하는 값의 다음 값을 next 로 선언
            바로 다음 값과 비교해서 현재 값과 작거나 같으면 작업을 한번에 처리해야 하므로 cnt ++
            만약 다음 값보다 현재 값이 크커나 같지 않다면 정답 List에 추가해주고 다시 1로 초기화
            만약 작업을 걸리는 시간이 모두 오름차순이라서 cnt를 증가할 필요가 없었다면 최초에 cnt를 초기화한 값 1을 추가.
         */


        int cnt = 1;
        double current = queue.poll();

        while (!queue.isEmpty()) {

            double next = queue.poll();

            if (current >= next) {
                cnt++;
            } else {

                answer.add(cnt);
                cnt = 1;
                current = next;
            }
        }
        answer.add(cnt);

        for (int i : answer) {
            System.out.println(i);
        }


        return answer;
    }


}

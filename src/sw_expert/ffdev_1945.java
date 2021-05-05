package sw_expert;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ffdev_1945 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] div = {2, 3, 5, 7, 11};


        for (int i=0; i < N; i++){

            List<Integer> list = new ArrayList<>();

            int[] test = new int[N];
            //System.out.println("테스트에 넣을 숫자를 입력해주세요.");
            test[i] = sc.nextInt();
            //System.out.println("추가한 숫자 : " + test[i]);

            for (int j = 0; j < div.length; j++){


                int cnt = 0;

                while (test[i] % div[j] == 0){

                    test[i] /= div[j];
                    //System.out.println("테스트케이스 : " + test[i] + " / " + "나누는 수 : " + div[j]);
                    cnt++;
                }

                list.add(cnt);
            }

            System.out.print("#"+ (i + 1));
            for(int a : list){

                System.out.print(" " + a);
            }
            System.out.println();

        }



    }



}

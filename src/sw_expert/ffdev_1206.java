package sw_expert;

import java.util.Scanner;

public class ffdev_1206 {

    public static void main(String[] args) {

        int test = 10;
        Scanner sc = new Scanner(System.in);

        for (int k=1; k <= test; k++){


            int width = sc.nextInt();
            int ans = 0;

            int[] buildings = new int[width];

            for(int i =0; i < width; i ++){
                buildings[i] = sc.nextInt();
            }



            for (int i = 2; i < buildings.length -2; i ++){

                if(buildings[i] < buildings[i-1] ||
                   buildings[i] < buildings[i+1] ||
                   buildings[i] < buildings[i-2] ||
                   buildings[i] < buildings[i+2]){
                    // 양옆의 건물보다 높이가 낮은 건물은 필요없음
                    System.out.println("양옆 pass = " + "[" + buildings[i-1] + "]" + " [" + buildings[i] + "]" + " [" + buildings[i+1] + "]");
                    continue;

                }

                int higher = Math.max( buildings[i-1], Math.max(buildings[i+1], Math.max(buildings[i-2], buildings[i+2])));
                ans += (buildings[i] - higher);

            }

            System.out.print("#" + k);
            System.out.print(" " + ans);
            System.out.println();


        }


    }

}

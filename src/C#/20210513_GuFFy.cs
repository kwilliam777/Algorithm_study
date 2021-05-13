using System;
using System.Collections.Generic;
public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[] {};
        int[] leftPeriod = new int[progresses.Length];
        List<int> tempAnswer = new List<int>();
        for (int i = 0; i < progresses.Length; i++)
        {
             leftPeriod[i] =  (100-progresses[i])/speeds[i];
        }
        
        bool Do =true;
        
        while(Do){
            var tuple =    DoRelease(leftPeriod);
            leftPeriod= tuple.Item2;
            tempAnswer.Add(tuple.Item1);
                if(tuple.Item3  ==0){
                    Do=false;
                    }
        }
        
        answer = tempAnswer.ToArray();
        
        
        
        
        return answer;
    }
    public (int,int[],int) DoRelease(int[] something){
        var temp = something[0];
            int count = 0;
            List<int> result = new List<int>();
            for (int i = 0; i < something.Length; i++)
            {
                int period = something[i];
                something[i] = period - temp;
            }

            if(something[0]<=0)
            for (int i = 0; i < something.Length; i++)
            {
                int item = something[i];
                if (item <= 0)
                {
                    count++;
                }
                else
                {
                        break;
                }
            }
            for (int i = count; i< something.Length; i++)
            {
                result.Add(something[i]);
            }
       
        return (count,result.ToArray(),result.Count); 
    }
}

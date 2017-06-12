package Q1_02_Check_Permutation;

import java.util.ArrayList;

/**
 * Created by ykhadilkar on 6/11/17.
 * Game
 *
 * X doubles the score
 * + adds last 2 scores
 * D removes the last score
 * Total is additions of all scores
 */

public class Game{
    public static int totalScore(String[] gameScore, int n){
        int totalScore = 0;
        int currentScore = 0;
        ArrayList<Integer> integer_scores = new ArrayList <Integer>();

        for(int i=0; i<n; i++){
            currentScore = 0;
            //case X
            if(gameScore[i]=="X"){
                if(integer_scores.size()>0){
                    currentScore = integer_scores.get(integer_scores.size()-1)*2;
                }else{
                    currentScore = 0;
                }

                integer_scores.add(currentScore);
            }
            //case +
            else if(gameScore[i] == "+"){
                if(integer_scores.size()>1){
                    currentScore = integer_scores.get(integer_scores.size()-1)+integer_scores.get(integer_scores.size()-2);
                }else if(integer_scores.size()>0){
                    currentScore = integer_scores.get(integer_scores.size()-1);
                }else{
                    currentScore = 0;
                }

                integer_scores.add(currentScore);
            }
            //case D
            else if(gameScore[i] == "D"){
                if(integer_scores.size()>0 && i>0) {
                    totalScore = totalScore - integer_scores.get(integer_scores.size()-1);
                    integer_scores.remove(integer_scores.size()-1);
                    currentScore = 0;
                }
            }
            //if number
            else{
                integer_scores.add(Integer.valueOf(gameScore[i]));
                currentScore = Integer.valueOf(gameScore[i]);
            }
            totalScore += currentScore;

        }
        System.out.println(integer_scores);
        return totalScore;
    }

    public static void main(String[] args){
        String[] scores= {"D","2","3","4","D","X","+","X","+","+","3","D"};
        System.out.println("Total Score: "+totalScore(scores,12));
    }
}
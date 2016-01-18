package idv.jiaming.ScoreRank;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ScoreRank {

	public static void main(String[] args) {		
		int[] testScores = {5,100,100,6,7,84,3,2,60};
		
		Map<Integer, Integer> rank = aggr(juni(testScores));
		for(Integer score: rank.keySet()){
			System.out.println(String.format("Score: %d, Rank: %d", score, rank.get(score)));
		}
	}

	public static Map<Integer, Integer> juni(int[] scores) {
		// Java lambda function. Sort the map by key
		Map<Integer, Integer> juni = new TreeMap<>((Integer i1, Integer i2) -> -i1.compareTo(i2));
				
		/*
		 * 100 ---> 2
		 * 84 ----> 1
		 * 60 ----> 1
		 * .
		 * .
		 * .
		 * 2 -----> 1
		 */
		for (int score : scores) {
			juni.put(score, juni.get(score) == null ? 1 : juni.get(score) + 1);
		}
		return juni;
	}
	
	public static Map<Integer, Integer> aggr(Map<Integer, Integer> juni){
		
		int count = 1;
		Map<Integer, Integer> rank = new HashMap<Integer,Integer>();
		
		// aggregate
		for(int score: juni.keySet()){
			rank.put(score, count);
			count += juni.get(score);
		}
		return rank;
	}
}

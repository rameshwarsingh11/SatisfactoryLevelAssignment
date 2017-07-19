package com.restaurant.menu;

import java.util.Arrays;

public class KnapSackAlgorithm {
	/**
	 * method to implement KnapSack
	 * 
	 * @param timeLimit
	 * @param eatingTimes
	 * @param degreeOfSatisfactions
	 * @param menuItemCount
	 * @return
	 */
	protected Integer doKnapSack(Integer timeLimit, Integer eatingTimes[], Integer degreeOfSatisfactions[],
			Integer menuItemCount) {
		if (menuItemCount != eatingTimes.length || menuItemCount != degreeOfSatisfactions.length) {
			throw new InvalidInputFormatException();
		}
		Integer i, w;
		Integer satisfactionMatrix[][] = new Integer[menuItemCount + 1][timeLimit + 1];
		for (i = 0; i <= menuItemCount; i++) {
			for (w = 0; w <= timeLimit; w++) {
				if (i == 0 || w == 0)
					satisfactionMatrix[i][w] = 0;
				else if (eatingTimes[i - 1] <= w)
					satisfactionMatrix[i][w] = Math.max(
							degreeOfSatisfactions[i - 1] + satisfactionMatrix[i - 1][w - eatingTimes[i - 1]],
							satisfactionMatrix[i - 1][w]);
				else
					satisfactionMatrix[i][w] = satisfactionMatrix[i - 1][w];
			}
		}
		String text = String.format(
				"\nInput: \n\tTime Limit: %s\n\tEating Times: %s\n\tDegree Of Satisfaction: %s\n\tMenu Item Count:%s\nOutput: \n\tMax Sat. Degree:%s\n",
				timeLimit, Arrays.toString(eatingTimes), Arrays.toString(degreeOfSatisfactions), menuItemCount,
				satisfactionMatrix[menuItemCount][timeLimit]);
		System.out.println(text);
		return satisfactionMatrix[menuItemCount][timeLimit];
	}
}

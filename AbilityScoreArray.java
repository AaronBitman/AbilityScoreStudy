package abilityScoreStudy;

import java.util.*;

public class AbilityScoreArray {
	// This class represents an array of 6 ability scores, which was rerolled if too low.

	private int scores[] = new int[6];
	
	public AbilityScoreArray () {
		// Create the ability score array.
		do {
			for (int index = 0; index < scores.length; index++) {
				scores[index] = generate_ability_score();
			}
		} while (too_low());
	}

	private int generate_ability_score() {
		// Generate a single ability score by rolling 4d6 and adding up the highest 3.
		int rolls[] = new int[4];
		Random rand = new Random();
		for (int index = 0; index < rolls.length; index++)
			rolls[index] = rand.nextInt(6) + 1;
		Arrays.sort(rolls);
		return rolls[1] + rolls[2] + rolls[3];
	}

	private boolean too_low() {
		// An ability score array is considered "too low" if its total
		// modifiers are 0 or less, or if the highest score is 13 or lower.
		int total_modifiers = 0, highest_score = 0;
		for (int score : scores) {
			total_modifiers += modifier(score);
			if (score > highest_score) highest_score = score;
		}
		return highest_score <= 13 || total_modifiers <= 0;
	}

	private int modifier(int score) {
		// Given an ability score, return the modifier;
		// divide by 2 (rounding down) and subtract 5.
		return score / 2 - 5;
	}

	public int total() {
		// Compute the total of the ability scores.
		int sum = 0;
		for (int score : scores) 
			sum += score;
		return sum;
	}
}

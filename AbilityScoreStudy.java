package abilityScoreStudy;

import java.math.BigInteger;

public class AbilityScoreStudy {

	public static void main(String[] args) {
		// Determine the average ability score when they're generated with the
		// 3.0 / 3.5 rules of 4d6-take-the-highest-3-and-reroll-if-too-low.
		// I find the results are stable at a sample size of 10,000 ability score arrays.
		// But I tried a sample size of 1 billion, which took about 15 minutes.
		// The short story is that the result is about 12.5.
		final int SAMPLE_SIZE = 10_000;
		BigInteger total = new BigInteger("0");
		for (int index = 0; index < SAMPLE_SIZE; index++) {
			AbilityScoreArray abilityScoreArray = new AbilityScoreArray();
			total = total.add(BigInteger.valueOf(abilityScoreArray.total()));
		}
		float totalAsFloat = total.floatValue();
		System.out.println(totalAsFloat/SAMPLE_SIZE/6);
	}
}

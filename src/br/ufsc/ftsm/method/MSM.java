package br.ufsc.ftsm.method;

import br.ufsc.ftsm.core.Trajectory;
import br.ufsc.ftsm.util.Distance;

/*
 * Implementation of the Spatial-Only MSM, in order to adapt for more dimensions it is necessary to 
 * include the required thresholds and implement the Matching Function
 */
public class MSM{
	
	double spaceThreshold;

	public MSM(double spaceThreshold) {
		this.spaceThreshold = spaceThreshold;
	}

	public double getDistance(Trajectory A, Trajectory B) {
		int n = A.length();
		int m = B.length();
		double aScore[] = new double[n];
		double bScore[] = new double[m];

		double parityAB = 0.0;

		for (int i = 0; i < n; i++) {
			double score = 0.0;
			double maxScore = 0.0;

			for (int j = 0; j < m; j++) {
				//Matching Function to calculate the score
				score = (Distance.euclidean(A.getPoint(i), B.getPoint(j)) <= spaceThreshold) ? 1 : 0;

				if (score >= maxScore) {
					maxScore = score;
					bScore[j] = maxScore > bScore[j] ? maxScore : bScore[j];
				}
			}
			aScore[i] = maxScore;
			parityAB += maxScore;
		}

		double parityBA = 0.0;
		for (int j = 0; j < m; j++) {
			parityBA += bScore[j];
		}

		double similarity = (parityAB + parityBA) / (n + m);

		return similarity;
	}

}

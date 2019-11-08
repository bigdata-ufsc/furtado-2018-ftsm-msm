package br.ufsc.ftsm.core.test;

import java.sql.SQLException;

import br.ufsc.ftsm.core.Trajectory;
import br.ufsc.ftsm.method.FTSMBMSM;
import br.ufsc.ftsm.method.MSM;

/*
 * It is necessary to retrieve two trajectories from the database or a file to test the method
 */
public class Test {
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		Trajectory t1 = null; //retrieve trajectory1
		Trajectory t2 = null; //retrieve trajectory1

		// MSM-based measures
		MSM msm = new MSM(100);
		FTSMBMSM ftsmbmsm = new FTSMBMSM(100);
	
		System.out.println("### MSM-Based:");
		System.out.println("MSM: " + msm.getDistance(t1, t2));
		System.out.println("FTSMBMSM: " + ftsmbmsm.getDistance(t1, t2));

	}

}

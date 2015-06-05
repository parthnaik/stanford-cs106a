/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */

import acm.util.*;
import java.util.*;

public class NameSurferEntry implements NameSurferConstants {
	
	/* Instance Variables */
	private String name;
	private int[] namePopularityStats = new int[NDECADES];

	/* Constructor: NameSurferEntry(line) */
	/**
	 * Creates a new NameSurferEntry from a data line as it appears
	 * in the data file.  Each line begins with the name, which is
	 * followed by integers giving the rank of that name for each
	 * decade.
	 */
	public NameSurferEntry(String line) {
		// You fill this in //
		parseLine(line);
	}
	
	private void parseLine(String line) {
		// Get name of person
		int nameEnd = line.indexOf(" ");
		name = line.substring(0, nameEnd);
		
		String numbers = line.substring(nameEnd + 1);
		StringTokenizer st = new StringTokenizer(numbers);
		
		for (int i = 0; st.hasMoreTokens(); i++) {
			int ranking = Integer.parseInt(st.nextToken());
			namePopularityStats[i] = ranking;
		}
	}

	/* Method: getName() */
	/**
	 * Returns the name associated with this entry.
	 */
	public String getName() {
		// You need to turn this stub into a real implementation //
		return name;
	}

	/* Method: getRank(decade) */
	/**
	 * Returns the rank associated with an entry for a particular
	 * decade.  The decade value is an integer indicating how many
	 * decades have passed since the first year in the database,
	 * which is given by the constant START_DECADE.  If a name does
	 * not appear in a decade, the rank value is 0.
	 */
	public int getRank(int decade) {
		// You need to turn this stub into a real implementation //
		return namePopularityStats[decade];
	}

	/* Method: toString() */
	/**
	 * Returns a string that makes it easy to see the value of a
	 * NameSurferEntry.
	 */
	public String toString() {
		// You need to turn this stub into a real implementation //
		String data = name + " [";
		
		for (int i = 0; i < NDECADES; i++) {
			if (i == NDECADES - 1) { data += namePopularityStats[i] + "]"; break; }
			data += namePopularityStats[i] + " ";
		}
		
		return data;
	}
}


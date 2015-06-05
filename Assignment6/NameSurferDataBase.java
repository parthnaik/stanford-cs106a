/*
 * File: NameSurferDataBase.java
 * -----------------------------
 * This class keeps track of the complete database of names.
 * The constructor reads in the database from a file, and
 * the only public method makes it possible to look up a
 * name and get back the corresponding NameSurferEntry.
 * Names are matched independent of case, so that "Eric"
 * and "ERIC" are the same names.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import acm.util.*;

import java.util.*;

public class NameSurferDataBase implements NameSurferConstants {
	/* Instance Variables */
	private Map <String, NameSurferEntry> nameSurferDB = new HashMap <String, NameSurferEntry>();
	
	/* Constructor: NameSurferDataBase(filename) */
	/**
	 * Creates a new NameSurferDataBase and initializes it using the
	 * data in the specified file.  The constructor throws an error
	 * exception if the requested file does not exist or if an error
	 * occurs as the file is being read.
	 */
	public NameSurferDataBase(String filename) {
		// You fill this in //
		populateMap(filename);
	}
	
	private void populateMap(String filename) {
		BufferedReader file = fileReader(filename);
		
		try {
			while (true) {
				String line = file.readLine();
				if (line == null) break;
				// code to populate hashmap
				NameSurferEntry entry = new NameSurferEntry(line);
				nameSurferDB.put(entry.getName(), entry);
			} 
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
	}
	
	private BufferedReader fileReader(String filename) {
		BufferedReader rd = null;
		
		while (rd == null) {
			try {
				rd = new BufferedReader(new FileReader(filename));
			} catch (IOException ex) {
				throw new ErrorException(ex);
			}
		}
		
		return rd;
	}
	
	/* Method: findEntry(name) */
	/**
	 * Returns the NameSurferEntry associated with this name, if one
	 * exists.  If the name does not appear in the database, this
	 * method returns null.
	 */
	public NameSurferEntry findEntry(String name) {
		// You need to turn this stub into a real implementation //
		return nameSurferDB.get(name);
	}
}
package br.bodoque;

import java.util.HashMap;
import java.util.Map;

public class Sequence {

	private static Map<Class<? extends Prevalent>, Long> sequences;
	
	static {
		sequences = new HashMap<Class<? extends Prevalent>, Long>();
	}
	
	static Long getNextIdFor(Class<? extends Prevalent> prevalentObjectClass) {
		Long nextId = sequences.get(prevalentObjectClass);
		if (nextId == null) {
			sequences.put(prevalentObjectClass, 1L);
			nextId = 1L;
		} else 
			sequences.put(prevalentObjectClass, ++nextId);

		return nextId;
	}

	static void clearSequenceFor(Class<? extends Prevalent> prevalentObjectClass) {
		sequences.remove(prevalentObjectClass);
	}

	static void clearSequences() {
		sequences.clear();
	}
}
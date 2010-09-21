/*******************************************************************************
 * Copyright (c) 2010 Torsten Zesch.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Torsten Zesch - initial API and implementation
 ******************************************************************************/
package de.tudarmstadt.ukp.wikipedia.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import de.tudarmstadt.ukp.wikipedia.api.WikiConstants.Language;
import de.tudarmstadt.ukp.wikipedia.api.exception.WikiInitializationException;

public class CategoryIteratorTest {

	private Wikipedia wiki;
	
	@Before
	public void setupWikipedia() {
		DatabaseConfiguration db = new DatabaseConfiguration();
		db.setDatabase("wikiapi_test");
		db.setHost("bender.tk.informatik.tu-darmstadt.de");
		db.setUser("student");
		db.setPassword("student");
		db.setLanguage(Language._test);
		
		try {
			wiki = new Wikipedia(db);
		} catch (WikiInitializationException e) {
			fail("Wikipedia could not be initialized.");
		}
	}
	

	/**
	 * The test wikipedia contains 17 categories.
	 */
	@Test
	public void test_categoryIteratorTest() {
		int nrOfPages = 0;
		
		Iterator<Category> catIter = wiki.getCategories().iterator();
		
		while (catIter.hasNext()) {
			@SuppressWarnings("unused")
			Category c = catIter.next();
			nrOfPages++;
		}
		assertEquals("Number of categories == 17", 17, nrOfPages);
		
	}
	
	/**
	 * The test wikipedia contains 17 categories.
	 */
	@Test
	public void test_categoryIteratorTestBufferSize() {
		
		for (int bufferSize=1;bufferSize<=100;bufferSize+=5) {
			Iterator<Category> catIter = wiki.getCategories(bufferSize).iterator();
			int nrOfPages = 0;
			while (catIter.hasNext()) {
				@SuppressWarnings("unused")
				Category c = catIter.next();
				nrOfPages++;
			}
			assertEquals("Number of categories == 17", 17, nrOfPages);
		}
	}
}
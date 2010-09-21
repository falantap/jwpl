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

import java.util.Comparator;

import de.tudarmstadt.ukp.wikipedia.api.exception.WikiTitleParsingException;

/**
 * Compares two pages based on the lexicographic ordering of their titles.
 * @author zesch
 *
 */
public class PageTitleComparator implements Comparator<Page> {
        
    public int compare(Page o1, Page o2) {

        int retVal = 0;
        try {
            retVal = o1.getTitle().getPlainTitle().compareTo(o2.getTitle().getPlainTitle());
        } catch (WikiTitleParsingException e) {
            e.printStackTrace();
        }
        return retVal;
    }
}
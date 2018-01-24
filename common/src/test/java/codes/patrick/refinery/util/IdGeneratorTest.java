/*
 * Copyright © 2018 Patrick Lavigne
 *
 * This file is part of file-refinery.
 *
 * file-refinery is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * file-refinery is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public
 * License along with file-refinery.  If not, see <http://www.gnu.org/licenses/>.
 */

package codes.patrick.refinery.util;

import codes.patrick.refinery.test.TestBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdGeneratorTest extends TestBase {

    @Test
    void testGetIdString() {
        // Verify it returns "" for anything 0 or less
        String testId = IdGenerator.getIdString(-1);
        assertTrue(testId.isEmpty());
        testId = IdGenerator.getIdString(0);
        assertTrue(testId.isEmpty());

        // Verify length
        testId = IdGenerator.getIdString(1);
        assertEquals(1, testId.length());
        testId = IdGenerator.getIdString(500);
        assertEquals(500, testId.length());

        // Check if ID's are actually different
        String compareId = IdGenerator.getIdString(500);
        assertNotEquals(testId, compareId);
    }
}

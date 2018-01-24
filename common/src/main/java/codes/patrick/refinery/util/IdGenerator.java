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

import org.apache.commons.math3.random.MersenneTwister;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.SynchronizedRandomGenerator;
import org.jetbrains.annotations.NotNull;

/**
 * Utility class for generating random unique IDs
 *
 * @author Patrick Lavigne
 */
public class IdGenerator {
    private static final RandomGenerator rng = new SynchronizedRandomGenerator(new MersenneTwister());

    /**
     * Set of possible characters an ID string can be built from
     */
    public static final char[] ID_CHARACTER_SET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /**
     * Generate an ID string of the specified length
     * @param length Length of ID string to generate
     * @return An ID string
     */
    @NotNull
    public static String getIdString(final int length) {
        final StringBuilder sb = new StringBuilder();
        for(int pos = 0; pos < length; ++pos) {
            sb.append(ID_CHARACTER_SET[rng.nextInt(ID_CHARACTER_SET.length)]);
        }
        return sb.toString();
    }

}

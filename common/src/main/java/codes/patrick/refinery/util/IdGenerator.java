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
 * Utility class for generating random unique IDs.
 *
 * @author Patrick Lavigne
 */
public final class IdGenerator {
  /**
   * Default set of possible characters an ID string can be built from.
   */
  public static final char[]
    DEFAULT_ID_CHARACTER_SET =
    "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

  /**
   * Set of possible characters an ID string can be built from. Defaults to {@link IdGenerator#DEFAULT_ID_CHARACTER_SET}
   * and can be overridden using the system property {@code codes.patrick.refinery.id-character-set}.
   */
  public static final char[] ID_CHARACTER_SET;

  /**
   * Default length of an ID string.
   */
  public static final int DEFAULT_ID_LENGTH = 16;

  /**
   * Length of an ID string if no length parameter is passed to {@link IdGenerator#getIdString(int)}. Must be greater
   * than 0. Defaults to {@link IdGenerator#DEFAULT_ID_LENGTH} and can be overridden using the system property
   * {@code codes.patrick.refinery.id-length}.
   */
  public static final int ID_LENGTH;

  private static final RandomGenerator rng = new SynchronizedRandomGenerator(new MersenneTwister());

  static {
    char[] idCharacterSet;
    int idLength;
    try {
      final String value = System.getProperty("codes.patrick.refinery.id-character-set", null);
      idCharacterSet = (value == null || value.isEmpty()) ? DEFAULT_ID_CHARACTER_SET : value.toCharArray();
    } catch (final SecurityException | NullPointerException | IllegalArgumentException err) {
      // Set defaults if an error occurred reading system properties
      idCharacterSet = DEFAULT_ID_CHARACTER_SET;
    }

    try {
      final String value = System.getProperty("codes.patrick.refinery.id-length", null);
      idLength = (value == null || value.isEmpty()) ? DEFAULT_ID_LENGTH : Integer.parseInt(value);
      if (idLength <= 0) {
        idLength = DEFAULT_ID_LENGTH;
      }
    } catch (final SecurityException | NullPointerException | IllegalArgumentException err) {
      // Set defaults if an error occurred reading system properties
      idLength = DEFAULT_ID_LENGTH;
    }

    ID_CHARACTER_SET = idCharacterSet;
    ID_LENGTH = idLength;
  }

  private IdGenerator() {
  }

  /**
   * Generate an ID string of length {@link IdGenerator#ID_LENGTH}.
   *
   * @return An ID string
   */
  @NotNull
  public static String getIdString() {
    return getIdString(ID_LENGTH);
  }

  /**
   * Generate an ID string of the specified length.
   *
   * @param length Length of ID string to generate
   * @return An ID string
   */
  @NotNull
  public static String getIdString(final int length) {
    if (length <= 0) {
      return "";
    }
    final StringBuilder sb = new StringBuilder();
    for (int pos = 0; pos < length; ++pos) {
      sb.append(ID_CHARACTER_SET[rng.nextInt(ID_CHARACTER_SET.length)]);
    }
    return sb.toString();
  }

}

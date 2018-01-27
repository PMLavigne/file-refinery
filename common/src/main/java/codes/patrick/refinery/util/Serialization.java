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

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class for basic serialization / deserialization. This is just for testing for now, and will be refactored
 * into a separate package.
 *
 * @author Patrick Lavigne
 */
public final class Serialization {
  private static final ObjectMapper mapper;

  private static final Logger log = LoggerFactory.getLogger(Serialization.class);

  static {
    mapper = new ObjectMapper();
    mapper.enable(SerializationFeature.INDENT_OUTPUT);
  }

  private Serialization() {
  }

  /**
   * Serialize the given object into JSON.
   *
   * @param object The object to serialize
   * @return A string containing the serialized JSON representation of the object
   * @throws JsonProcessingException If serialization failed
   */
  public static String serialize(@NotNull final Object object) throws JsonProcessingException {
    log.trace("Serializing: {}", object);
    final String result = mapper.writeValueAsString(object);
    log.trace("Serialization result:\n{}", result);
    return result;
  }

  /**
   * Deserialize an object from JSON data.
   *
   * @param data  JSON string of data to deserialize
   * @param clazz Class of type to deserialize the JSON as
   * @param <T>   Type to deserialize the JSON as
   * @return The deserialized JSON object
   * @throws IOException If deserialization failed
   */
  public static <T> T deserialize(@NotNull final String data, @NotNull final Class<T> clazz) throws IOException {
    log.trace("Deserializing:\n{}", data);
    final T result = mapper.readValue(data, clazz);
    log.trace("Deserialization result: {}", result);
    return result;
  }
}

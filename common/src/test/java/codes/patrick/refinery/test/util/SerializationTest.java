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

package codes.patrick.refinery.test.util;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import codes.patrick.refinery.test.TestBase;
import codes.patrick.refinery.util.Serialization;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SerializationTest extends TestBase {

  @Test
  void testSerializeBasic() throws JsonProcessingException {
    final SerializationTestObject testObject = new SerializationTestObject("SerializationTest-testSerializeBasic");
    final String result = Serialization.serialize(testObject);
    assertNotNull(result);
    assertFalse(result.trim().isEmpty());
    assertEquals(result, "{\n  \"name\" : \"SerializationTest-testSerializeBasic\"\n}");
  }

  @Test
  void testSerializeRecursive() throws JsonProcessingException {
    final SerializationTestObject testObject =
      new SerializationTestObject("SerializationTest-testSerializeRecursive");
    testObject.getChildren()
      .add(new SerializationTestSubObject("SerializationTest-testSerializeRecursive-sub1", testObject));
    final SerializationTestSubObject sub2 = new SerializationTestSubObject(
      "SerializationTest-testSerializeRecursive-sub2", testObject);
    testObject.getChildren().add(sub2);
    sub2.getChildren()
      .add(new SerializationTestSubObject("SerializationTest-testSerializeRecursive-sub3", sub2));
    final String result = Serialization.serialize(testObject);
    assertNotNull(result);
    assertFalse(result.trim().isEmpty());
  }

  @Test
  void testDeserializeBasic() throws IOException {
    final String json = "{\n  \"name\" : \"SerializationTest-testDeserializeBasic\"\n}";
    final SerializationTestObject result = Serialization.deserialize(json, SerializationTestObject.class);
    assertNotNull(result);
    assertEquals("SerializationTest-testDeserializeBasic", result.getName());
    assertTrue(result.getChildren().isEmpty());
  }

  @XmlRootElement
  @XmlAccessorType(XmlAccessType.FIELD)
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  static class SerializationTestObject {
    private final String name;

    @JsonManagedReference
    @JsonProperty("children")
    private final Set<SerializationTestObject> children;

    SerializationTestObject(@Nullable final String name) {
      this(name, null);
    }

    @JsonCreator
    SerializationTestObject(@Nullable
                            @JsonProperty(required = true, value = "name") final String name,
                            @Nullable
                            @JsonProperty("children") final Collection<SerializationTestObject> children) {
      this.name = name;
      this.children = children == null ? new CopyOnWriteArraySet<>() : new CopyOnWriteArraySet<>(children);
    }

    @Nullable
    public String getName() {
      return name;
    }

    @NotNull
    public Set<SerializationTestObject> getChildren() {
      return children;
    }

    @NotNull
    @Override
    public String toString() {
      return "" + getName() + " (" + getChildren().size() + " children)";
    }
  }

  @XmlRootElement
  @XmlAccessorType(XmlAccessType.FIELD)
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  static class SerializationTestSubObject extends SerializationTestObject {

    @JsonBackReference
    @JsonProperty("parent")
    private final SerializationTestObject parent;

    SerializationTestSubObject(@Nullable
                               @JsonProperty(required = true, value = "name") final String name,
                               @NotNull
                               @JsonProperty(required = true, value = "parent") final SerializationTestObject parent) {
      this(name, parent, null);
    }

    @JsonCreator
    SerializationTestSubObject(@Nullable
                               @JsonProperty(required = true, value = "name") final String name,
                               @NotNull
                               @JsonProperty(required = true, value = "parent") final SerializationTestObject parent,
                               @Nullable
                               @JsonProperty("children") final Collection<SerializationTestObject> children) {
      super(name, children);
      this.parent = parent;
    }

    @Nullable
    public SerializationTestObject getParent() {
      return parent;
    }
  }
}

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

package codes.patrick.refinery.conf;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

/**
 * Definition of a {@link codes.patrick.refinery.RefiningTask}. Used to set up and configure the refinery pipeline.
 * Generally this would be deserialized from a config file, but you could also generate it programmatically.
 *
 * @author Patrick Lavigne
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RefiningTaskDefinition implements Serializable {
  @JsonProperty(value = "name")
  @JsonPropertyDescription("Name of the task. Mainly used in logging and debugging")
  private String name;
}

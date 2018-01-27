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

package codes.patrick.refinery;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.jetbrains.annotations.NotNull;

/**
 * A part of the refining system itself, for example a {@link RefiningProcess} or {@link RefiningTask}.
 *
 * @author Patrick Lavigne
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface RefiningComponent extends Serializable {
  /**
   * A unique ID that identifies this component in the refinery system.
   *
   * @return An ID that is unique to this component
   * @see codes.patrick.refinery.util.IdGenerator#getIdString IdGenerator.getIdString() for generating unique ID's
   */
  @NotNull
  String getId();

  /**
   * A name for this component. Names are printed to logs and used to aid debugging, so use something meaningful.
   *
   * @return This component's name
   */
  @NotNull
  String getName();
}

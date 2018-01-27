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

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import codes.patrick.refinery.fs.SourceFile;
import codes.patrick.refinery.util.IdGenerator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * An ordered list of actions to perform on a {@link SourceFile}. A {@link RefiningProcess} consists of one or more
 * {@link RefiningStep RefiningSteps}, which must be run serially.
 *
 * @author Patrick Lavigne
 */
public class RefiningProcess extends AbstractRefiningComponent {
  private final List<RefiningStep> steps;

  /**
   * Create a RefiningProcess with the specified name and an empty list of {@link RefiningStep Steps}. The ID will
   * be generated automatically by {@link IdGenerator#getIdString()}.
   *
   * @param name Name of the refining process to create.
   */
  public RefiningProcess(@NotNull final String name) {
    this(null, name, null);
  }

  /**
   * Create a RefiningProcess with the specified name, and optionally a list of {@link RefiningStep Steps}. The ID will
   * be generated automatically by {@link IdGenerator#getIdString()}.
   *
   * @param name  Name of the refining process to create.
   * @param steps List of {@link RefiningStep Steps} that are executed in this process. If null, an empty list will be
   *              created.
   */
  public RefiningProcess(@NotNull final String name, @Nullable final List<RefiningStep> steps) {
    this(null, name, steps);
  }

  /**
   * Create a RefiningProcess with the specified name, and optionally a specified unique ID and list of
   * {@link RefiningStep Steps}.
   *
   * @param id    Unique ID of the component. If null, use {@link IdGenerator#getIdString()} to generate one.
   * @param name  Name of the refining process to create.
   * @param steps List of {@link RefiningStep Steps} that are executed in this process. If null, an empty list will be
   *              created.
   */
  public RefiningProcess(@Nullable final String id,
                         @NotNull final String name,
                         @Nullable final List<RefiningStep> steps) {
    super(id, name);
    this.steps = steps != null ? new CopyOnWriteArrayList<>(steps) : new CopyOnWriteArrayList<>();
  }

  /**
   * Retrieve the list of {@link RefiningStep RefiningSteps} that make up this {@link RefiningProcess}.
   *
   * @return The {@link RefiningStep RefiningSteps} that make up this {@link RefiningProcess}
   */
  @NotNull
  public List<RefiningStep> getSteps() {
    return this.steps;
  }
}

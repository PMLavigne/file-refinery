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

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import codes.patrick.refinery.util.IdGenerator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A single stage of a {@link RefiningProcess}. They are run serially. Within each RefiningStep is one or more
 * {@link RefiningTask RefiningTasks}, which may run in parallel or out of order.
 *
 * @author Patrick Lavigne
 */
public class RefiningStep extends AbstractRefiningComponent {
  private final Set<RefiningTask> tasks;

  /**
   * Create an empty RefiningStep, without any {@link RefiningTask RefiningTasks}.
   *
   * @param name Name of this Step
   */
  public RefiningStep(@NotNull final String name) {
    this(IdGenerator.getIdString(), name, null);
  }

  /**
   * Create the RefiningStep with the given {@link RefiningTask RefiningTasks}. If null, create an empty RefiningStep
   *
   * @param name  Name of this Step
   * @param tasks Collection of {@link RefiningTask RefiningTasks} that make up this RefiningStep, or null to create
   *              an empty RefiningStep
   */
  public RefiningStep(@NotNull final String name, @Nullable final Collection<RefiningTask> tasks) {
    this(IdGenerator.getIdString(), name, tasks);
  }

  /**
   * Create the RefiningStep with the given {@link RefiningTask RefiningTasks} and ID. If null, create an empty
   * RefiningStep
   *
   * @param id    Unique ID of this RefiningStep
   * @param name  Name of this RefiningStep
   * @param tasks Collection of {@link RefiningTask RefiningTasks} that make up this RefiningStep, or null to create
   *              an empty RefiningStep
   */
  public RefiningStep(@NotNull final String id,
                      @NotNull final String name,
                      @Nullable final Collection<RefiningTask> tasks) {
    super(id, name);
    this.tasks = tasks != null ? new CopyOnWriteArraySet<>(tasks) : new CopyOnWriteArraySet<>();
  }

  /**
   * Get the {@link RefiningTask Tasks} that are to be done during this RefiningStep. {@link RefiningTask Tasks} may
   * be executed in parallel or out of order
   *
   * @return The collection of {@link RefiningTask Tasks} that will be done for this RefiningStep
   */
  @NotNull
  public Set<RefiningTask> getTasks() {
    return this.tasks;
  }
}

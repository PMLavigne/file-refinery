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

import codes.patrick.refinery.util.IdGenerator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * A single stage of a {@link Process}. They are run serially. Within each Step is one or more {@link Task}s,
 * which may run in parallel or out of order.
 *
 * @author Patrick Lavigne
 */
public class Step extends AbstractRefiningComponent {
    private final Set<Task> tasks;

    /**
     * Create an empty Step, without any {@link Task Tasks}
     */
    public Step() {
        this(IdGenerator.getIdString(), null);
    }

    /**
     * Create the Step with the given {@link Task Tasks}. If null, create an empty Step
     * @param tasks Collection of {@link Task Tasks} that make up this Step, or null to create an empty Step
     */
    public Step(@Nullable final Collection<Task> tasks) {
        this(IdGenerator.getIdString(), tasks);
    }

    /**
     * Create the Step with the given {@link Task Tasks} and ID. If null, create an empty Step
     *
     * @param id    Unique ID of this Step
     * @param tasks Collection of {@link Task Tasks} that make up this Step, or null to create an empty Step
     */
    public Step(@NotNull final String id, @Nullable final Collection<Task> tasks) {
        super(id);
        this.tasks = tasks != null ? new CopyOnWriteArraySet<>(tasks) : new CopyOnWriteArraySet<>();
    }

    /**
     * Get the {@link Task}s that are to be done during this Step. {@link Task}s may be executed in parallel or out
     * of order
     * @return The collection of {@link Task}s that will be done for this Step
     */
    @NotNull
    public Set<Task> getTasks() {
        return this.tasks;
    }

    @Override
    public @NotNull String getId() {
        return null;
    }
}

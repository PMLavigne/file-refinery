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

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * An ordered list of actions to perform on a {@link SourceFile}. A {@link Process} consists of one or more
 * {@link Step}s, which must be run serially
 *
 * @author Patrick Lavigne
 */
public class Process extends AbstractRefiningComponent {
    private final List<Step> steps;

    public Process() {
        this(IdGenerator.getIdString(), null);
    }

    public Process(@Nullable final List<Step> steps) {
        this(IdGenerator.getIdString(), steps);
    }

    public Process(@NotNull final String id, @Nullable final List<Step> steps) {
        super(id);
        this.steps = steps != null ? new CopyOnWriteArrayList<>(steps) : new CopyOnWriteArrayList<>();
    }

    /**
     * Retrieve the list of {@link Step}s that make up this {@link Process}
     * @return The {@link Step}s that make up this {@link Process}
     */
    @NotNull
    public List<Step> getSteps() {
        return this.steps;
    }
}

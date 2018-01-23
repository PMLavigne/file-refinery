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
import java.util.Collection;

/**
 * A single stage of a {@link Process}. They are run serially. Within each {@link Step} is one or more {@link Task}s,
 * which may run in parallel.
 */
public interface Step extends Serializable {
    /**
     * Get the {@link Task}s that are to be done during this {@link Step}. Tasks may be executed in parallel or out
     * of order
     * @return The collection of {@link Task}s that will be done for this {@link Step}
     */
    Collection<Task> getTasks();
}

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

/**
 * Basic abstract implementation of {@link RefiningComponent}
 *
 * @author Patrick Lavigne
 */
public abstract class AbstractRefiningComponent implements RefiningComponent {
    private final String id;
    private final String name;

    /**
     * Create the component with the specified name and a unique ID randomly generated by
     * {@link IdGenerator#getIdString()}
     */
    protected AbstractRefiningComponent(@NotNull final String name) {
        this(IdGenerator.getIdString(), name);
    }

    /**
     * Create the component with the specified unique ID and name
     *
     * @param id Unique ID of the component
     */
    protected AbstractRefiningComponent(@NotNull final String id, @NotNull final String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public String getId() {
        return this.id;
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public String getName() {
        return this.name;
    }
}

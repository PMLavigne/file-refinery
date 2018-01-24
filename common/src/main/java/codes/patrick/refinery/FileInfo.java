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

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

/**
 * Generic representation of file information
 *
 * @author Patrick Lavigne
 */
public abstract class FileInfo implements Serializable {
    private final String id;
    private final String name;
    private final Metadata metadata;

    protected FileInfo(@NotNull final String id, @NotNull final String name) {
        this(id, name, new Metadata());
    }

    protected FileInfo(@NotNull final String id, @NotNull final String name, @NotNull final Metadata metadata) {
        this.id = id;
        this.name = name;
        this.metadata = metadata;
    }

    /**
     * A unique ID that identifies this file in the Refinery system. An ID corresponding to a file should remain the
     * same through the entire refining process.
     * @return An ID that is unique to this file
     * @see codes.patrick.refinery.util.IdGenerator
     */
    @NotNull
    public String getId() {
        return id;
    }

    /**
     * The name of the file, including extension, but not including any path information
     * @return The name of the file
     */
    @NotNull
    public String getName() {
        return name;
    }

    /**
     * The file extension, not including the period. The default implementation returns anything after the final period
     * in the value returned by {@link #getName()}.
     * @return The file extension, or null if none
     */
    @Nullable
    public String getExtension() {
        final String name = getName();
        final int periodPos = name.lastIndexOf('.');
        return periodPos < 0 ? null : name.substring(periodPos+1);
    }

    /**
     * The collection of metadata pertaining to this file
     * @return This file's metadata
     */
    @NotNull
    public Metadata getMetadata() {
        return metadata;
    }

    /**
     * Basic toString implementation, returns the ID and Name separated by a space
     *
     * @return String representation of this object
     */
    @NotNull
    public String toString() {
        return getId() + " " + getName();
    }
}

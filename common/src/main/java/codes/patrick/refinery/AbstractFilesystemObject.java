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
import com.fasterxml.jackson.annotation.JsonInclude;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

/**
 * Abstract representation of a filesystem object (generally a directory or file of some type). For refining purposes,
 * a filesystem object has a unique ID, a name, and associated {@link Metadata}
 *
 * @author Patrick Lavigne
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractFilesystemObject implements Serializable {
    private final String id;
    private final String name;
    private final Metadata metadata;

    protected AbstractFilesystemObject(@NotNull final String name,
                                       @NotNull final Metadata metadata) {
        this(IdGenerator.getIdString(), name, metadata);
    }

    protected AbstractFilesystemObject(@NotNull final String id,
                                       @NotNull final String name,
                                       @NotNull final Metadata metadata) {
        this.id = id;
        this.name = name;
        this.metadata = metadata;
    }

    /**
     * A unique ID that identifies this filesystem object in the refinery system. An ID corresponding to a filesystem
     * object must remain the same through the entire refining process.
     *
     * @return An ID that is unique to this filesystem object
     * @see codes.patrick.refinery.util.IdGenerator#getIdString IdGenerator.getIdString() for generating unique ID's
     */
    @NotNull
    public String getId() {
        return id;
    }

    /**
     * The name of the filesystem object
     *
     * @return The name of the filesystem object
     */
    @NotNull
    public String getName() {
        return name;
    }

    /**
     * The collection of metadata pertaining to this filesystem object
     *
     * @return This filesystem object's metadata
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

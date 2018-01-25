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

package codes.patrick.refinery.fs;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

/**
 * Abstract representation of a filesystem object (generally a directory or file of some type) in the refinery's virtual
 * filesystem. For refining purposes, a filesystem object has a unique ID, a name, and associated {@link Metadata}
 *
 * @author Patrick Lavigne
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface FilesystemObject extends Serializable {
    /**
     * A unique ID that identifies this filesystem object in the refinery system. An ID corresponding to a filesystem
     * object must remain the same through the entire refining process.
     *
     * @return An ID that is unique to this filesystem object
     * @see codes.patrick.refinery.util.IdGenerator#getIdString IdGenerator.getIdString() for generating unique ID's
     */
    @NotNull
    String getId();

    /**
     * The name of the filesystem object
     *
     * @return The name of the filesystem object
     */
    @NotNull
    String getName();

    /**
     * The collection of {@link Metadata metadata} pertaining to this filesystem object
     *
     * @return This filesystem object's metadata
     */
    @NotNull
    Metadata getMetadata();
}

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

/**
 * Generic representation of file information
 *
 * @author Patrick Lavigne
 */
public abstract class FileInfo extends AbstractFilesystemObject {
    protected FileInfo(@NotNull final String name) {
        this(IdGenerator.getIdString(), name, new Metadata());
    }

    protected FileInfo(@NotNull final String name, @NotNull final Metadata metadata) {
        this(IdGenerator.getIdString(), name, metadata);
    }

    protected FileInfo(@NotNull final String id, @NotNull final String name) {
        this(id, name, new Metadata());
    }

    protected FileInfo(@NotNull final String id, @NotNull final String name, @NotNull final Metadata metadata) {
        super(id, name, metadata);
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
}

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

import org.jetbrains.annotations.NotNull;

/**
 * Abstract representation of a directory in the refinery's virtual filesystem
 *
 * @author Patrick Lavigne
 */
public class Directory extends AbstractFilesystemObject {

    protected Directory(final @NotNull String name,
                        final @NotNull Metadata metadata) {
        super(name, metadata);
    }

    protected Directory(final @NotNull String id,
                        final @NotNull String name,
                        final @NotNull Metadata metadata) {
        super(id, name, metadata);
    }
}

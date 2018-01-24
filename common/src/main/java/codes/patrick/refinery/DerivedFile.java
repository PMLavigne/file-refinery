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

/**
 * A file that has been derived by refining a {@link SourceFile}, either directly from the {@link SourceFile} or from
 * a different intermediate {@link DerivedFile}.
 *
 * @author Patrick Lavigne
 */
public class DerivedFile extends FileInfo {

    public DerivedFile(@NotNull String id, @NotNull String name) {
        super(id, name);
    }

    public DerivedFile(@NotNull String id, @NotNull String name, @NotNull Metadata metadata) {
        super(id, name, metadata);
    }
}

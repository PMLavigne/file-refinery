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

import java.util.Set;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * The raw file being refined.
 *
 * @author Patrick Lavigne
 */
public class SourceFile extends AbstractFile {
  public SourceFile(@NotNull final String name) {
    this(null, name, null, null);
  }

  public SourceFile(@NotNull final String name, @Nullable final Set<DerivedFile> derivedFiles) {
    this(null, name, null, derivedFiles);
  }

  public SourceFile(@Nullable final String id, @NotNull final String name) {
    this(id, name, null, null);
  }

  public SourceFile(@Nullable final String id,
                    @NotNull final String name,
                    @Nullable final Set<DerivedFile> derivedFiles) {
    this(id, name, null, derivedFiles);
  }

  public SourceFile(@NotNull final String name, @Nullable final Metadata metadata) {
    this(null, name, metadata, null);
  }

  public SourceFile(@Nullable final String id,
                    @NotNull final String name,
                    @Nullable final Metadata metadata,
                    @Nullable final Set<DerivedFile> derivedFiles) {
    super(id, name, metadata, derivedFiles);
  }

  /**
   * Implementation of {@link AbstractFile#getParentFile()} that just returns null, because SourceFiles are originals
   * and as a result don't have parents.
   *
   * @return Always returns null
   */
  @Override
  @Nullable
  public AbstractFile getParentFile() {
    return null;
  }
}

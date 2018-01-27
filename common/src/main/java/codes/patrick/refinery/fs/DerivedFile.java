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

import codes.patrick.refinery.util.IdGenerator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A file that has been derived by refining a {@link SourceFile}, either directly from the {@link SourceFile} or from
 * a different intermediate {@link DerivedFile}.
 *
 * @author Patrick Lavigne
 */
public class DerivedFile extends AbstractFile {
  @JsonManagedReference
  private final AbstractFile parent;

  public DerivedFile(@NotNull final AbstractFile parent, @NotNull final String name) {
    this(null, parent, name, null, null);
  }

  public DerivedFile(@NotNull final AbstractFile parent,
                     @NotNull final String name,
                     @Nullable final Set<DerivedFile> derivedFiles) {
    this(null, parent, name, null, derivedFiles);
  }

  public DerivedFile(@Nullable final String id, @NotNull final AbstractFile parent, @NotNull final String name) {
    this(id, parent, name, null, null);
  }

  public DerivedFile(@Nullable final String id,
                     @NotNull final AbstractFile parent,
                     @NotNull final String name,
                     @Nullable final Set<DerivedFile> derivedFiles) {
    this(id, parent, name, null, derivedFiles);
  }

  public DerivedFile(@NotNull final String name,
                     @NotNull final AbstractFile parent,
                     @Nullable final Metadata metadata) {
    this(null, parent, name, metadata, null);
  }

  /**
   * Create the DerivedFile with the specified name and parent file, and optionally with a specified ID,
   * {@link Metadata} collection, and set of files derived from this one.
   *
   * @param id           Unique ID of this file object. If null, is generated using {@link IdGenerator#getIdString()}
   * @param parent       Parent file that this is derived from. DerivedFiles MUST have a parent.
   * @param name         Name of this file. This should include any extension, but not any path information.
   * @param metadata     Metadata pertaining to this file. If null, an empty set is created.
   * @param derivedFiles Files that are derived from this file. If null, an empty set is created.
   */
  public DerivedFile(@Nullable final String id,
                     @NotNull final AbstractFile parent,
                     @NotNull final String name,
                     @Nullable final Metadata metadata,
                     @Nullable final Set<DerivedFile> derivedFiles) {
    super(id, name, metadata, derivedFiles);
    this.parent = parent;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @Nullable
  public AbstractFile getParentFile() {
    return parent;
  }
}

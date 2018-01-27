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
import java.util.concurrent.CopyOnWriteArraySet;

import codes.patrick.refinery.util.IdGenerator;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Generic representation of file information.
 *
 * @author Patrick Lavigne
 */
public abstract class AbstractFile extends AbstractFilesystemObject {
  @JsonBackReference
  private final Set<DerivedFile> derivedFiles;

  /**
   * Create the object with the given name, and optionally with the specified ID, {@link Metadata} collection and set
   * of derived files generated from this file.
   *
   * @param id           Unique ID of this file object. If null, is generated using {@link IdGenerator#getIdString()}
   * @param name         Name of this file. This should include any extension, but not any path information.
   * @param metadata     Metadata pertaining to this file. If null, an empty set is created.
   * @param derivedFiles Files that are derived from this file. If null, an empty set is created.
   */
  protected AbstractFile(@Nullable final String id,
                         @NotNull final String name,
                         @Nullable final Metadata metadata,
                         @Nullable final Set<DerivedFile> derivedFiles) {
    super(id, name, metadata);
    this.derivedFiles = derivedFiles == null ? new CopyOnWriteArraySet<>() : new CopyOnWriteArraySet<>(derivedFiles);
  }

  /**
   * The file extension, not including the period. The default implementation returns anything after the final period
   * in the value returned by {@link #getName()}.
   *
   * @return The file extension, or null if none
   */
  @Nullable
  public String getExtension() {
    final String name = getName();
    final int periodPos = name.lastIndexOf('.');
    return periodPos < 0 ? null : name.substring(periodPos + 1);
  }

  /**
   * Retrieve the file that created this derived file. If this returns null, this is the original {@link SourceFile}
   * being processed. Otherwise, this is a {@link DerivedFile}.
   *
   * @return The file that created this derived file.
   */
  @Nullable
  public abstract AbstractFile getParentFile();

  /**
   * Get the set of files derived from this one.
   *
   * @return Set of files derived from this one
   */
  public Set<DerivedFile> getDerivedFiles() {
    return derivedFiles;
  }
}

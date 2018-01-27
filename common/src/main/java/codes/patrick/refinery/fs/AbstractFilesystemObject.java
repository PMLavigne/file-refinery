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

import codes.patrick.refinery.util.IdGenerator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Abstract base implementation of {@link FilesystemObject} for building things on top of.
 *
 * @author Patrick Lavigne
 */
public abstract class AbstractFilesystemObject implements FilesystemObject {
  private final String id;

  private final String name;

  private final Metadata metadata;

  /**
   * Create the object with a given name, optionally with the specified ID and Metadata.
   *
   * @param id       Unique ID of the object. If null, generate one using {@link IdGenerator#getIdString()}
   * @param name     Name of the object
   * @param metadata {@link Metadata} pertaining to the object. If null, create an empty metadata set
   */
  protected AbstractFilesystemObject(@Nullable final String id,
                                     @NotNull final String name,
                                     @Nullable final Metadata metadata) {
    this.id = id == null ? IdGenerator.getIdString() : id;
    this.name = name;
    this.metadata = metadata == null ? new Metadata() : metadata;
  }

  /**
   * {@inheritDoc}
   */
  @NotNull
  @Override
  public String getId() {
    return id;
  }

  /**
   * {@inheritDoc}
   */
  @NotNull
  @Override
  public String getName() {
    return name;
  }

  /**
   * {@inheritDoc}
   */
  @NotNull
  @Override
  public Metadata getMetadata() {
    return metadata;
  }

  /**
   * Basic toString implementation, returns the {@link #getId() id} and {@link #getName() name} separated by a space.
   *
   * @return String representation of this object
   */
  @NotNull
  @Override
  public String toString() {
    return getId() + " " + getName();
  }
}

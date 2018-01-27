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

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import codes.patrick.refinery.util.IdGenerator;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Abstract representation of a directory in the refinery's virtual filesystem.
 *
 * @author Patrick Lavigne
 */
public class Directory extends AbstractFilesystemObject {
  @JsonProperty("parent")
  @JsonManagedReference("directory-parent-child")
  private final Directory parent;

  @JsonProperty("children")
  @JsonBackReference("directory-parent-child")
  private final Set<Directory> children;

  @JsonProperty("files")
  @JsonManagedReference("directory-files")
  private final Set<AbstractFile> files;

  protected Directory(final @NotNull String name) {
    this(null, null, name, null, null, null);
  }

  protected Directory(final @Nullable Directory parent,
                      final @NotNull String name) {
    this(null, parent, name, null, null, null);
  }

  protected Directory(final @Nullable Directory parent,
                      final @NotNull String name,
                      final @Nullable Metadata metadata) {
    this(null, null, name, null, null, null);
  }

  /**
   * Create a new Directory instance with the given name, and optionally the given unique ID, parent Directory,
   * child Directories, contained files and directory {@link Metadata} collection.
   *
   * @param id       Unique ID of the object. If null, will be generated via {@link IdGenerator#getIdString()}
   * @param parent   Parent enclosing directory. If null, this is a root
   * @param name     Name of the directory
   * @param metadata Directory metadata collection
   * @param children Child directories contained within this Directory. If null, creates an empty set
   * @param files    AbstractFiles contained within this Directory. If null, creates an empty set
   */
  protected Directory(final @Nullable String id,
                      final @Nullable Directory parent,
                      final @NotNull String name,
                      final @Nullable Metadata metadata,
                      final @Nullable Collection<Directory> children,
                      final @Nullable Collection<AbstractFile> files) {
    super(id, name, metadata);
    this.parent = parent;
    this.children = children == null ? new CopyOnWriteArraySet<>() : new CopyOnWriteArraySet<>(children);
    this.files = files == null ? new CopyOnWriteArraySet<>() : new CopyOnWriteArraySet<>(files);
  }

  /**
   * The parent of this Directory, or null if this is the root of the virtual filesystem.
   *
   * @return Parent directory, or null if root
   */
  @Nullable
  public Directory getParent() {
    return parent;
  }

  @NotNull
  public Set<Directory> getChildren() {
    return children;
  }

  @NotNull
  public Set<AbstractFile> getFiles() {
    return files;
  }
}

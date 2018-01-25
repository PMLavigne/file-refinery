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

import codes.patrick.refinery.fs.DerivedFile;
import codes.patrick.refinery.fs.Metadata;
import codes.patrick.refinery.fs.SourceFile;

/**
 * An action to apply to a {@link SourceFile}. RefiningTasks within the same {@link RefiningStep} may be executed in
 * parallel or out of order. RefiningTasks can accept as input the {@link SourceFile}, any {@link DerivedFile}s that
 * have been created in previous {@link RefiningStep RefiningSteps}, and all associated {@link Metadata}.
 *
 * @author Patrick Lavigne
 */
public interface RefiningTask extends RefiningComponent {
}

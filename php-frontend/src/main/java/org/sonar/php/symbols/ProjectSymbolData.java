/*
 * SonarQube PHP Plugin
 * Copyright (C) 2010-2020 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.php.symbols;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.sonar.plugins.php.api.symbols.QualifiedName;

/**
 * Instances of this class should never hold references to an AST node: we want to have a low memory usage for the
 * analysis of a project and an AST node basically keeps references to the whole AST of a file.
 */
public class ProjectSymbolData {

  private final Map<QualifiedName, ClassSymbolData> classSymbolsByQualifiedName = new HashMap<>();

  public void add(ClassSymbolData classSymbolData) {
    classSymbolsByQualifiedName.put(classSymbolData.qualifiedName(), classSymbolData);
  }

  public Optional<ClassSymbolData> classSymbolData(QualifiedName qualifiedName) {
    return Optional.ofNullable(classSymbolsByQualifiedName.get(qualifiedName));
  }

}

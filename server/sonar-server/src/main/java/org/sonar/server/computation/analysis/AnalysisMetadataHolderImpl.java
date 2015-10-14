/*
 * SonarQube, open source software quality management tool.
 * Copyright (C) 2008-2014 SonarSource
 * mailto:contact AT sonarsource DOT com
 *
 * SonarQube is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * SonarQube is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.server.computation.analysis;

import java.util.Date;
import javax.annotation.CheckForNull;

import static com.google.common.base.Preconditions.checkState;

public class AnalysisMetadataHolderImpl implements MutableAnalysisMetadataHolder {
  @CheckForNull
  private Long analysisDate;

  @CheckForNull
  private Boolean firstAnalysis;

  @Override
  public void setAnalysisDate(Date date) {
    checkState(analysisDate == null, "Analysis date has already been set");
    this.analysisDate = date.getTime();
  }

  @Override
  public Date getAnalysisDate() {
    checkState(analysisDate != null, "Analysis date has not been set");
    return new Date(this.analysisDate);
  }

  @Override
  public void setIsFirstAnalysis(boolean firstAnalysis) {
    checkState(this.firstAnalysis == null, "firstAnalysis flag has already been set");
    this.firstAnalysis = firstAnalysis;
  }

  @Override
  public boolean isFirstAnalysis() {
    checkState(firstAnalysis != null, "firstAnalysis flag has not been set");
    return firstAnalysis;
  }
}
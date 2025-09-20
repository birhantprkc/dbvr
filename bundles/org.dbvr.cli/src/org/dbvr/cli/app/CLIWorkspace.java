/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2010-2025 DBeaver Corp and others
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dbvr.cli.app;

import org.jkiss.code.NotNull;
import org.jkiss.code.Nullable;
import org.jkiss.dbeaver.model.app.DBPPlatform;
import org.jkiss.dbeaver.model.app.DBPProject;
import org.jkiss.dbeaver.model.impl.app.BaseWorkspaceImpl;
import org.jkiss.dbeaver.runtime.DBWorkbench;

import java.nio.file.Path;
import java.util.List;

/**
 * CLI workspace
 */
public class CLIWorkspace extends BaseWorkspaceImpl {

    private DBPProject activeProject;

    public CLIWorkspace(@NotNull DBPPlatform platform, @NotNull Path workspacePath) {
        super(platform, workspacePath);
        this.activeProject = null;
    }

    @NotNull
    @Override
    public DBPPlatform getPlatform() {
        return DBWorkbench.getPlatform();
    }

    @NotNull
    @Override
    public String getWorkspaceId() {
        return "CLI";
    }

    @NotNull
    @Override
    public List<? extends DBPProject> getProjects() {
        return List.of();
    }

    @Nullable
    @Override
    public DBPProject getActiveProject() {
        return activeProject;
    }

    @Nullable
    @Override
    public DBPProject getProject(@NotNull String projectName) {
        return null;
    }

    @Nullable
    @Override
    public DBPProject getProjectById(@NotNull String projectId) {
        return null;
    }

    @Override
    public void initializeProjects() {
        // noop
    }

    @Override
    public void dispose() {
    }

}

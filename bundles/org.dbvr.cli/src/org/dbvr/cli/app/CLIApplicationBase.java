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

import org.eclipse.equinox.app.IApplicationContext;
import org.jkiss.code.NotNull;
import org.jkiss.code.Nullable;
import org.jkiss.dbeaver.model.app.DBPPlatform;
import org.jkiss.dbeaver.model.impl.app.BaseApplicationImpl;
import org.jkiss.dbeaver.model.impl.preferences.SimplePreferenceStore;
import org.jkiss.dbeaver.model.preferences.DBPPreferenceStore;
import org.jkiss.dbeaver.runtime.ui.DBPPlatformUI;
import org.jkiss.dbeaver.runtime.ui.console.ConsoleUserInterface;

import java.nio.file.Path;

/**
 * Base CLI application
 */
public class CLIApplicationBase extends BaseApplicationImpl {

    @NotNull
    @Override
    public Object start(IApplicationContext context) throws Exception {
        System.out.println("CLI app started");
        return EXIT_OK;
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Nullable
    @Override
    public String getDefaultProjectName() {
        return null;
    }

    @Nullable
    @Override
    public Path getDefaultWorkingFolder() {
        return null;
    }

    @NotNull
    @Override
    public Class<? extends DBPPlatform> getPlatformClass() {
        return CLIPlatform.class;
    }

    @Override
    public Class<? extends DBPPlatformUI> getPlatformUIClass() {
        return ConsoleUserInterface.class;
    }

    @Override
    public boolean isStandalone() {
        return true;
    }

    @Override
    public boolean isHeadlessMode() {
        return true;
    }

    @Override
    public boolean isEnvironmentVariablesAccessible() {
        return true;
    }

    @NotNull
    public DBPPreferenceStore getPreferenceStore() {
        return new SimplePreferenceStore() {
            @Override
            public void save() {

            }
        };
    }

}

/*
 * Copyright (c) 2019, Wasiq Bhamla.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.wasiqb.coteafs.listeners.config;

/**
 * @author Wasiq Bhamla
 * @since 17-Sep-2019
 */
public class LogSetting {
    private boolean configurations;
    private boolean dataProvider;
    private boolean execution;
    private boolean suites;
    private boolean tests;

    /**
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     */
    public LogSetting () {
        this.configurations = true;
        this.suites = true;
        this.tests = true;
        this.execution = true;
        this.dataProvider = true;
    }

    /**
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     * @return the configurations
     */
    public boolean isConfigurations () {
        return this.configurations;
    }

    /**
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     * @return the dataProvider
     */
    public boolean isDataProvider () {
        return this.dataProvider;
    }

    /**
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     * @return the execution
     */
    public boolean isExecution () {
        return this.execution;
    }

    /**
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     * @return the suites
     */
    public boolean isSuites () {
        return this.suites;
    }

    /**
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     * @return the tests
     */
    public boolean isTests () {
        return this.tests;
    }

    /**
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     * @param configurations the configurations to set
     */
    public void setConfigurations (final boolean configurations) {
        this.configurations = configurations;
    }

    /**
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     * @param dataProvider the dataProvider to set
     */
    public void setDataProvider (final boolean dataProvider) {
        this.dataProvider = dataProvider;
    }

    /**
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     * @param execution the execution to set
     */
    public void setExecution (final boolean execution) {
        this.execution = execution;
    }

    /**
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     * @param suites the suites to set
     */
    public void setSuites (final boolean suites) {
        this.suites = suites;
    }

    /**
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     * @param tests the tests to set
     */
    public void setTests (final boolean tests) {
        this.tests = tests;
    }
}
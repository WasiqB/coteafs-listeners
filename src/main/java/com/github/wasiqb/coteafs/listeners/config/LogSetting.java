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

import com.github.wasiqb.coteafs.config.util.BasePojo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Wasiq Bhamla
 * @since 17-Sep-2019
 */
@Getter
@Setter
public class LogSetting extends BasePojo {
    private boolean configurations;
    private boolean dataProvider;
    private boolean execution;
    private boolean suiteResults;
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
        this.suiteResults = true;
    }
}
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

import java.util.ArrayList;
import java.util.List;

import com.github.wasiqb.coteafs.config.util.BasePojo;

/**
 * @author Wasiq Bhamla
 * @since 17-Sep-2019
 */
public class RetrySetting extends BasePojo {
    private boolean      enable;
    private boolean      logging;
    private int          maxRetry;
    private List<String> onExceptions;

    /**
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     */
    public RetrySetting () {
        this.enable = false;
        this.maxRetry = 2;
        this.logging = true;
        this.onExceptions = new ArrayList<> ();
    }

    /**
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     * @return the maxRetry
     */
    public int getMaxRetry () {
        return this.maxRetry;
    }

    /**
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     * @return the onClasses
     */
    public List<String> getOnExceptions () {
        return this.onExceptions;
    }

    /**
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     * @return the enable
     */
    public boolean isEnable () {
        return this.enable;
    }

    /**
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     * @return the logging
     */
    public boolean isLogging () {
        return this.logging;
    }

    /**
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     * @param enable the enable to set
     */
    public void setEnable (final boolean enable) {
        this.enable = enable;
    }

    /**
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     * @param logging the logging to set
     */
    public void setLogging (final boolean logging) {
        this.logging = logging;
    }

    /**
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     * @param maxRetry the maxRetry to set
     */
    public void setMaxRetry (final int maxRetry) {
        this.maxRetry = maxRetry;
    }

    /**
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     * @param onExceptions the onClasses to set
     */
    public void setOnExceptions (final List<String> onExceptions) {
        this.onExceptions = onExceptions;
    }
}
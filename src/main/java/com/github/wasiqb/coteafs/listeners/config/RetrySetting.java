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
    public RetrySetting() {
        this.enable = false;
        this.maxRetry = 2;
        this.logging = true;
        this.onExceptions = new ArrayList<>();
    }

    /**
     * @return the maxRetry
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     */
    public int getMaxRetry() {
        return this.maxRetry;
    }

    /**
     * @return the onClasses
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     */
    public List<String> getOnExceptions() {
        return this.onExceptions;
    }

    /**
     * @return the enable
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     */
    public boolean isEnable() {
        return this.enable;
    }

    /**
     * @return the logging
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     */
    public boolean isLogging() {
        return this.logging;
    }

    /**
     * @param enable the enable to set
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     */
    public void setEnable(final boolean enable) {
        this.enable = enable;
    }

    /**
     * @param logging the logging to set
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     */
    public void setLogging(final boolean logging) {
        this.logging = logging;
    }

    /**
     * @param maxRetry the maxRetry to set
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     */
    public void setMaxRetry(final int maxRetry) {
        this.maxRetry = maxRetry;
    }

    /**
     * @param onExceptions the onClasses to set
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     */
    public void setOnExceptions(final List<String> onExceptions) {
        this.onExceptions = onExceptions;
    }
}
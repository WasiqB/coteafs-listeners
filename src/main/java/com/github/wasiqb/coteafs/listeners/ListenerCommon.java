/*
 * Copyright (c) 2017-2020, Wasiq Bhamla.
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
package com.github.wasiqb.coteafs.listeners;

import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;
import static org.apache.commons.lang3.StringUtils.repeat;

import java.util.function.Consumer;

import com.github.wasiqb.coteafs.datasource.DataSource;
import com.github.wasiqb.coteafs.listeners.config.ListenerConfig;
import com.github.wasiqb.coteafs.listeners.config.LogSetting;
import org.apache.logging.log4j.Logger;

/**
 * @author wasiqb
 * @since Sep 25, 2018
 */
class ListenerCommon {
    public static final    LogSetting     LOG_CONFIG;
    protected static final ListenerConfig CONFIG;
    private static final   String         LINE;

    static {
        LINE = repeat ('=', 50);
        CONFIG = DataSource.parse (ListenerConfig.class);
        LOG_CONFIG = CONFIG.getLog ();
    }

    private final Logger log;
    private       long   start;

    /**
     * @param log Logger
     *
     * @author wasiqb
     * @since Sep 25, 2018
     */
    public ListenerCommon (final Logger log) {
        this.log = log;
    }

    /**
     * @param logger Logger
     * @param canLog Can log?
     *
     * @author wasiqb
     * @since Sep 25, 2018
     */
    protected void endLogging (final Consumer<Logger> logger, final boolean canLog) {
        if (canLog) {
            final var end = currentTimeMillis ();
            final var total = (end - this.start) / 1000.0;
            logMessage (logger.andThen (l -> l.info (format ("Total Time taken: %.3f secs", total))));
        }
    }

    protected void startLogging (final Consumer<Logger> logger, final boolean canLog) {
        if (canLog) {
            this.start = currentTimeMillis ();
            logMessage (logger);
        }
    }

    private void logMessage (final Consumer<Logger> logger) {
        this.log.info (LINE);
        logger.accept (this.log);
        this.log.info (LINE);
    }
}
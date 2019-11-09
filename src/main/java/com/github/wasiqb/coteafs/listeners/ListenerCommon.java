/**
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

import static com.github.wasiqb.coteafs.config.loader.ConfigLoader.settings;
import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;
import static org.apache.commons.lang3.StringUtils.repeat;

import java.util.function.Consumer;

import com.github.wasiqb.coteafs.listeners.config.ListenerConfig;
import com.github.wasiqb.coteafs.listeners.config.LogSetting;
import com.github.wasiqb.coteafs.logger.Loggy;

/**
 * @author wasiqb
 * @since Sep 25, 2018
 */
class ListenerCommon {
    public static final LogSetting        LOG_CONFIG;
    protected static final ListenerConfig CONFIG;
    private static final String           LINE;

    static {
        LINE = repeat ('=', 50);
        CONFIG = settings ().withKey ("coteafs.listener.config")
            .withDefault ("listener-config.yml")
            .load (ListenerConfig.class);
        LOG_CONFIG = CONFIG.getLog ();
    }

    private final Loggy log;
    private long        start;

    /**
     * @author wasiqb
     * @param log
     * @since Sep 25, 2018
     */
    public ListenerCommon (final Loggy log) {
        this.log = log;
    }

    protected void endLogging (final Consumer<Loggy> logger, final boolean canLog) {
        if (canLog) {
            final long end = currentTimeMillis ();
            final double total = (end - this.start) / 1000.0;
            logMessage (logger.andThen (l -> l.i (format ("Total Time taken: %.3f secs", total))));
        }
    }

    protected void startLogging (final Consumer<Loggy> logger, final boolean canLog) {
        if (canLog) {
            this.start = currentTimeMillis ();
            logMessage (logger);
        }
    }

    private void logMessage (final Consumer<Loggy> logger) {
        this.log.i (LINE);
        logger.accept (this.log);
        this.log.i (LINE);
    }
}
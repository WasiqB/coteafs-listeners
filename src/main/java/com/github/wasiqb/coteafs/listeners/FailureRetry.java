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
package com.github.wasiqb.coteafs.listeners;

import java.util.List;

import com.github.wasiqb.coteafs.listeners.config.RetrySetting;
import com.github.wasiqb.coteafs.logger.Loggy;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author Wasiq Bhamla
 * @since 17-Sep-2019
 */
public class FailureRetry extends ListenerCommon implements IRetryAnalyzer {
    private static final Loggy LOG = Loggy.init ();
    private int                retryCount;

    /**
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     */
    public FailureRetry () {
        super (LOG);
    }

    /*
     * (non-Javadoc)
     * @see @see org.testng.IRetryAnalyzer#retry(org.testng.ITestResult)
     */
    @SuppressWarnings ("unchecked")
    @Override
    public boolean retry (final ITestResult result) {
        final RetrySetting setting = CONFIG.getRecover ();
        if (!result.isSuccess () && setting.isEnable ()) {
            final boolean doLog = setting.isLogging ();
            final int maxRetry = setting.getMaxRetry ();
            final List<String> exceptions = setting.getOnExceptions ();
            startLogging (l -> l.i ("Started to retry the failed test [{}]...", result.getName ()), doLog);
            while (this.retryCount++ < maxRetry) {
                for (final String ex : exceptions) {
                    try {
                        final Class<? extends Exception> cls = (Class<? extends Exception>) Class.forName (ex);
                        if (cls.isInstance (result.getThrowable ())) {
                            return true;
                        }
                    } catch (final ClassNotFoundException e) {
                        startLogging (l -> l.e ("Exception Class not found: {}", e.getMessage ()), doLog);
                    }
                }
            }
        }
        return false;
    }
}
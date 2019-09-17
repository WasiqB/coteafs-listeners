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

import static com.github.wasiqb.coteafs.logger.Loggy.init;

import com.github.wasiqb.coteafs.logger.Loggy;

import org.testng.ISuite;
import org.testng.ISuiteListener;

/**
 * @author wasiqb
 * @since Sep 25, 2018
 */
public class SuiteListener extends ListenerCommon implements ISuiteListener {
    private static final Loggy   LOG       = init ();
    private static final boolean SUITE_LOG = LOG_CONFIG.isSuites ();

    /**
     * @author Wasiq Bhamla
     * @since 14-Sep-2019
     */
    public SuiteListener () {
        super (LOG);
    }

    /*
     * (non-Javadoc)
     * @see org.testng.ISuiteListener#onFinish(org.testng.ISuite)
     */
    @Override
    public void onFinish (final ISuite suite) {
        endLogging (l -> l.i ("Test Suite Execution finished for Suite [{}]...", suite.getName ()), SUITE_LOG);
    }

    /*
     * (non-Javadoc)
     * @see org.testng.ISuiteListener#onStart(org.testng.ISuite)
     */
    @Override
    public void onStart (final ISuite suite) {
        startLogging (l -> l.i ("Test Suite Execution started for Suite [{}]...", suite.getName ()), SUITE_LOG);
    }
}
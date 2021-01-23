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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IConfigurationListener;
import org.testng.ITestResult;

/**
 * @author wasiqb
 * @since Sep 25, 2018
 */
public class ConfigListener extends ListenerCommon implements IConfigurationListener {
    private static final boolean CONFIG_LOG = ListenerCommon.LOG_CONFIG.isConfigurations ();
    private static final Logger  LOG        = LogManager.getLogger ();

    /**
     * @author wasiqb
     * @since Sep 25, 2018
     */
    public ConfigListener () {
        super (LOG);
    }

    /*
     * (non-Javadoc)
     * @see org.testng.IConfigurationListener2#beforeConfiguration(org.testng.
     * ITestResult)
     */
    @Override
    public void beforeConfiguration (final ITestResult tr) {
        startLogging (l -> l.info ("Configuration method [{}] is executing...", tr.getName ()), CONFIG_LOG);
    }

    /*
     * (non-Javadoc)
     * @see org.testng.IConfigurationListener#onConfigurationFailure(org.testng.
     * ITestResult)
     */
    @Override
    public void onConfigurationFailure (final ITestResult itr) {
        endLogging (l -> {
            l.fatal ("[-] - Configuration method [{}] FAILED to execute...", itr.getName ());
            l.fatal (itr.getThrowable ()
                .getMessage ());
        }, CONFIG_LOG);
    }

    /*
     * (non-Javadoc)
     * @see
     * org.testng.IConfigurationListener#onConfigurationSkip(org.testng.ITestResult)
     */
    @Override
    public void onConfigurationSkip (final ITestResult itr) {
        endLogging (l -> l.warn ("[*] - Configuration method [{}] SKIPPED from execution...", itr.getName ()),
            CONFIG_LOG);
    }

    /*
     * (non-Javadoc)
     * @see org.testng.IConfigurationListener#onConfigurationSuccess(org.testng.
     * ITestResult)
     */
    @Override
    public void onConfigurationSuccess (final ITestResult itr) {
        endLogging (l -> l.info ("[+] - Configuration method [{}] PASSED...", itr.getName ()), CONFIG_LOG);
    }
}
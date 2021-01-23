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

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IDataProviderListener;
import org.testng.IDataProviderMethod;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;

/**
 * @author Wasiq Bhamla
 * @since 15-Sep-2019
 */
public class DataProviderListener extends ListenerCommon implements IDataProviderListener {
    private static final boolean DP_LOG = ListenerCommon.LOG_CONFIG.isDataProvider ();
    private static final Logger  LOG    = LogManager.getLogger ();

    /**
     * @author Wasiq Bhamla
     * @since 15-Sep-2019
     */
    public DataProviderListener () {
        super (LOG);
    }

    /*
     * (non-Javadoc)
     * @see @see
     * org.testng.IDataProviderListener#afterDataProviderExecution(org.testng.
     * IDataProviderMethod, org.testng.ITestNGMethod, org.testng.ITestContext)
     */
    @Override
    public void afterDataProviderExecution (final IDataProviderMethod dataProviderMethod, final ITestNGMethod method,
        final ITestContext iTestContext) {
        endLogging (l -> {
            l.info ("Data provider [{}] execution completed...", method.getMethodName ());
            final Map<String, String> params = method.findMethodParameters (iTestContext.getCurrentXmlTest ());
            params.forEach ((k, v) -> l.info ("{}: {}", k, v));
        }, DP_LOG);
    }

    /*
     * (non-Javadoc)
     * @see @see
     * org.testng.IDataProviderListener#beforeDataProviderExecution(org.testng.
     * IDataProviderMethod, org.testng.ITestNGMethod, org.testng.ITestContext)
     */
    @Override
    public void beforeDataProviderExecution (final IDataProviderMethod dataProviderMethod, final ITestNGMethod method,
        final ITestContext iTestContext) {
        startLogging (l -> l.info ("Data provider [{}] execution started...", method.getMethodName ()), DP_LOG);
    }
}
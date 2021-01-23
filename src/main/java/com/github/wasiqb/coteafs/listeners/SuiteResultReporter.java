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

import static org.apache.commons.lang3.StringUtils.repeat;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

/**
 * @author Wasiq Bhamla
 * @since 09-Nov-2019
 */
public class SuiteResultReporter implements IReporter {
    private static final String  LINE             = repeat ('=', 50);
    private static final Logger  LOG              = LogManager.getLogger ();
    private static final String  SUB_LINE         = repeat ('-', 50);
    private static final boolean SUITE_RESULT_LOG = ListenerCommon.LOG_CONFIG.isSuiteResults ();

    /*
     * (non-Javadoc)
     * @see @see org.testng.IReporter#generateReport(java.util.List, java.util.List,
     * java.lang.String)
     */
    @Override
    public void generateReport (final List<XmlSuite> xmlSuites, final List<ISuite> suites,
        final String outputDirectory) {
        if (SUITE_RESULT_LOG) {
            for (final ISuite suite : suites) {
                LOG.info (LINE);
                LOG.info ("Suite [{}]: {}", suite.getName (), suite.getSuiteState ()
                                                                  .isFailed () ? "Failed" : "Passed");
                LOG.info (SUB_LINE);
                final Map<String, ISuiteResult> results = suite.getResults ();
                for (final ISuiteResult result : results.values ()) {
                    final ITestContext tc = result.getTestContext ();
                    LOG.info ("Total Tests: {}", tc.getAllTestMethods ().length);
                    LOG.info ("Passed Tests: {}", tc.getPassedTests ()
                        .size ());
                    LOG.info ("Failed Tests: {}", tc.getFailedTests ()
                        .size ());
                    LOG.info ("Skipped Tests: {}", tc.getSkippedTests ()
                        .size ());
                }
                LOG.info (LINE);
            }
        }
    }
}
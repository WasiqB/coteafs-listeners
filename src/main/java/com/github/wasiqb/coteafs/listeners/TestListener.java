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

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * @author wasiqb
 * @since Sep 25, 2018
 */
public class TestListener extends ListenerCommon implements ITestListener {
    private static final Loggy LOG = init ();

    /**
     * @author wasiqb
     * @since Sep 25, 2018
     */
    public TestListener () {
        super (LOG);
    }

    /*
     * (non-Javadoc)
     * @see org.testng.ITestListener#onFinish(org.testng.ITestContext)
     */
    @Override
    public void onFinish (final ITestContext context) {
        endLogging (l -> l.i ("Test Execution finished for Test [{}]...", context.getName ()));
    }

    /*
     * (non-Javadoc)
     * @see org.testng.ITestListener#onStart(org.testng.ITestContext)
     */
    @Override
    public void onStart (final ITestContext context) {
        startLogging (l -> l.i ("Test Execution started for Test [{}]...", context.getName ()));
    }

    /*
     * (non-Javadoc)
     * @see
     * org.testng.ITestListener#onTestFailedButWithinSuccessPercentage(org.testng.
     * ITestResult)
     */
    @Override
    public void onTestFailedButWithinSuccessPercentage (final ITestResult result) {
        endLogging (l -> l.e ("[--] - [{}] PARTIAL FAILED...", result.getName ()));
    }

    /*
     * (non-Javadoc)
     * @see @see
     * org.testng.ITestListener#onTestFailedWithTimeout(org.testng.ITestResult)
     */
    @Override
    public void onTestFailedWithTimeout (final ITestResult result) {
        endLogging (l -> {
            l.e ("[-] - [{}] FAILED with Timeout...", result.getName ());
            l.e (result.getThrowable ()
                .getMessage ());
        });
    }

    /*
     * (non-Javadoc)
     * @see org.testng.ITestListener#onTestFailure(org.testng.ITestResult)
     */
    @Override
    public void onTestFailure (final ITestResult result) {
        endLogging (l -> {
            l.f ("[-] - [{}] FAILED...", result.getName ());
            l.f (result.getThrowable ()
                .getMessage ());
        });
    }

    /*
     * (non-Javadoc)
     * @see org.testng.ITestListener#onTestSkipped(org.testng.ITestResult)
     */
    @Override
    public void onTestSkipped (final ITestResult result) {
        endLogging (l -> l.w ("[*] - [{}] SKIPPED...", result.getName ()));
    }

    /*
     * (non-Javadoc)
     * @see org.testng.ITestListener#onTestStart(org.testng.ITestResult)
     */
    @Override
    public void onTestStart (final ITestResult result) {
        startLogging (l -> l.i ("Test Execution started for method [{}]...", result.getName ()));
    }

    /*
     * (non-Javadoc)
     * @see org.testng.ITestListener#onTestSuccess(org.testng.ITestResult)
     */
    @Override
    public void onTestSuccess (final ITestResult result) {
        endLogging (l -> l.i ("[+] - [{}] PASSED...", result.getName ()));
    }
}
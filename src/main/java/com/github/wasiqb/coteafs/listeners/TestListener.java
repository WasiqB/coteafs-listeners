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

import static org.apache.logging.log4j.LogManager.getLogger;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * @author wasiqb
 * @since Sep 25, 2018
 */
public class TestListener extends ListenerCommon implements ITestListener {
	private static final Logger log = getLogger (TestListener.class);

	/**
	 * @author wasiqb
	 * @since Sep 25, 2018
	 */
	public TestListener () {
		super (log);
	}

	/*
	 * (non-Javadoc)
	 * @see org.testng.ITestListener#onFinish(org.testng.ITestContext)
	 */
	@Override
	public void onFinish (final ITestContext context) {
		logTestContext (log::info, context, "Test Execution finished for Test [%s]...");
	}

	/*
	 * (non-Javadoc)
	 * @see org.testng.ITestListener#onStart(org.testng.ITestContext)
	 */
	@Override
	public void onStart (final ITestContext context) {
		logTestContext (log::info, context, "Test Execution started for Test [%s]...");
	}

	/*
	 * (non-Javadoc)
	 * @see org.testng.ITestListener#onTestFailedButWithinSuccessPercentage(org.testng.ITestResult)
	 */
	@Override
	public void onTestFailedButWithinSuccessPercentage (final ITestResult result) {
		logTestResult (log::warn, result, "[--] - [%s] PARTIAL FAILED...");
	}

	/*
	 * (non-Javadoc)
	 * @see org.testng.ITestListener#onTestFailure(org.testng.ITestResult)
	 */
	@Override
	public void onTestFailure (final ITestResult result) {
		logTestResult (log::fatal, result, "[-] - [%s] FAILED...");
		logTestResult (log::fatal, result, result.getThrowable ());
	}

	/*
	 * (non-Javadoc)
	 * @see org.testng.ITestListener#onTestSkipped(org.testng.ITestResult)
	 */
	@Override
	public void onTestSkipped (final ITestResult result) {
		logTestResult (log::error, result, "[*] - [%s] SKIPPED...");
	}

	/*
	 * (non-Javadoc)
	 * @see org.testng.ITestListener#onTestStart(org.testng.ITestResult)
	 */
	@Override
	public void onTestStart (final ITestResult result) {
		logTestResult (log::info, result, "Test Execution started for method [%s]...");
	}

	/*
	 * (non-Javadoc)
	 * @see org.testng.ITestListener#onTestSuccess(org.testng.ITestResult)
	 */
	@Override
	public void onTestSuccess (final ITestResult result) {
		logTestResult (log::info, result, "[+] - [%s] PASSED...");
	}
}
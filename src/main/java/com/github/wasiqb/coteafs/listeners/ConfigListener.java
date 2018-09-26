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
import org.testng.IConfigurationListener2;
import org.testng.ITestResult;

/**
 * @author wasiqb
 * @since Sep 25, 2018
 */
public class ConfigListener extends ListenerCommon implements IConfigurationListener2 {
	private static final Logger log = getLogger (ConfigListener.class);

	/**
	 * @author wasiqb
	 * @since Sep 25, 2018
	 */
	public ConfigListener () {
		super (log);
	}

	/*
	 * (non-Javadoc)
	 * @see org.testng.IConfigurationListener2#beforeConfiguration(org.testng.ITestResult)
	 */
	@Override
	public void beforeConfiguration (final ITestResult tr) {
		logTestResult (log::info, tr, "Configuration method [%s] is executing...");
	}

	/*
	 * (non-Javadoc)
	 * @see org.testng.IConfigurationListener#onConfigurationFailure(org.testng.ITestResult)
	 */
	@Override
	public void onConfigurationFailure (final ITestResult itr) {
		logTestResult (log::fatal, itr, "[-] - Configuration method [%s] FAILED to execute...");
		logTestResult (log::fatal, itr, itr.getThrowable ());
	}

	/*
	 * (non-Javadoc)
	 * @see org.testng.IConfigurationListener#onConfigurationSkip(org.testng.ITestResult)
	 */
	@Override
	public void onConfigurationSkip (final ITestResult itr) {
		logTestResult (log::warn, itr, "[*] - Configuration method [%s] SKIPPED from execution...");
	}

	/*
	 * (non-Javadoc)
	 * @see org.testng.IConfigurationListener#onConfigurationSuccess(org.testng.ITestResult)
	 */
	@Override
	public void onConfigurationSuccess (final ITestResult itr) {
		logTestResult (log::info, itr, "[+] - Configuration method [%s] PASSED...");
	}
}
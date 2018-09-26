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

import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;
import static java.time.Duration.ofMillis;
import static org.apache.commons.lang3.StringUtils.repeat;
import static org.apache.logging.log4j.LogManager.getLogger;

import java.util.function.Consumer;

import org.apache.logging.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;

/**
 * @author wasiqb
 * @since Sep 25, 2018
 */
public class SuiteListener implements ISuiteListener {
	private static final String	line	= repeat ('=', 50);
	private static final Logger	log		= getLogger (SuiteListener.class);

	private long	end;
	private long	start;

	/*
	 * (non-Javadoc)
	 * @see org.testng.ISuiteListener#onFinish(org.testng.ISuite)
	 */
	@Override
	public void onFinish (final ISuite suite) {
		this.end = currentTimeMillis ();
		logTestSuite (s -> log.info (s), suite, "Test Suite Execution finished for Suite [%s]...");
	}

	/*
	 * (non-Javadoc)
	 * @see org.testng.ISuiteListener#onStart(org.testng.ISuite)
	 */
	@Override
	public void onStart (final ISuite suite) {
		this.start = currentTimeMillis ();
		logTestSuite (s -> log.info (s), suite, "Test Suite Execution started for Suite [%s]...");
	}

	private void logTestSuite (final Consumer <String> res, final ISuite suite,
			final String message) {
		log.info (line);
		res.accept (format (message, suite.getName ()));
		if (this.end > this.start) {
			final long total = this.end - this.start;
			log.info (format ("Time taken: %d secs", ofMillis (total).getSeconds ()));
		}
		log.info (line);
	}
}
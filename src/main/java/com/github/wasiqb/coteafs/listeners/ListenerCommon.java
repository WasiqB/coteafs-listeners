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
import static java.time.Duration.ofMillis;
import static org.apache.commons.lang3.StringUtils.repeat;

import java.util.function.Consumer;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;

/**
 * @author wasiqb
 * @since Sep 25, 2018
 */
class ListenerCommon {
	private static final String line = repeat ('=', 50);

	private final Logger log;

	/**
	 * @author wasiqb
	 * @param log
	 * @since Sep 25, 2018
	 */
	public ListenerCommon (final Logger log) {
		this.log = log;
	}

	protected void logTestContext (final Consumer <String> res, final ITestContext context,
			final String message) {
		this.log.info (line);
		res.accept (format (message, context.getName ()));
		if (context.getEndDate () != null) {
			this.log.info (format ("Test executed on [%s]...", context.getEndDate ()));
		}
		this.log.info (line);
	}

	protected void logTestResult (final Consumer <String> res, final ITestResult result,
			final String message) {
		this.log.info (line);
		res.accept (format (message, result.getName ()));
		if (result.getStatus () != ITestResult.STARTED) {
			final long start = result.getStartMillis ();
			final long end = result.getEndMillis ();
			final long total = end - start;
			this.log.info (format ("Time taken: %d secs", ofMillis (total).getSeconds ()));
		}
		this.log.info (line);
	}

	protected void logTestResult (final Consumer <String> res, final ITestResult result,
			final Throwable cause) {
		if (cause != null) {
			logTestResult (res, result, cause.getMessage ());
		} else {
			logTestResult (res, result, "Unknown Exception!!");
		}
	}
}
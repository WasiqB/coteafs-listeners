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

import static com.github.wasiqb.coteafs.logger.Loggy.init;

import com.github.wasiqb.coteafs.logger.Loggy;

import org.testng.IExecutionListener;

/**
 * @author Wasiq Bhamla
 * @since 14-Sep-2019
 */
public class ExecutionListener extends ListenerCommon implements IExecutionListener {
    private static final Loggy LOG = init ();

    /**
     * @author Wasiq Bhamla
     * @since 14-Sep-2019
     */
    public ExecutionListener () {
        super (LOG);
    }

    /*
     * (non-Javadoc)
     * @see @see org.testng.IExecutionListener#onExecutionFinish()
     */
    @Override
    public void onExecutionFinish () {
        endLogging (l -> l.i ("TestNG Execution finished..."));
    }

    /*
     * (non-Javadoc)
     * @see @see org.testng.IExecutionListener#onExecutionStart()
     */
    @Override
    public void onExecutionStart () {
        startLogging (l -> l.i ("TestNG Execution started..."));
    }
}
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

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author wasiqb
 * @since Sep 25, 2018
 */
public class ListenerTest {
    private static int countRetry;

    /**
     * @author wasiqb
     * @since Sep 25, 2018
     */
    @BeforeTest
    public void setupTest () {
        countRetry = 0;
        return;
    }

    /**
     * @author wasiqb
     * @since Sep 25, 2018
     */
    @AfterTest
    public void teardownTest () {
        return;
    }

    /**
     * @author Wasiq Bhamla
     * @since 15-Sep-2019
     * @return data
     */
    @DataProvider
    public Iterator<Object []> testData () {
        final List<Object []> data = new ArrayList<> ();
        data.add (new Object [] { true });
        return data.iterator ();
    }

    /**
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     * @throws FileNotFoundException
     */
    @Test
    public void testRetry () throws FileNotFoundException {
        countRetry++;
        if (countRetry < 2) {
            throw new FileNotFoundException ();
        }
    }

    /**
     * @author wasiqb
     * @param value
     * @since Sep 25, 2018
     */
    @Test (dataProvider = "testData")
    public void testSuccess (final boolean value) {
        Assert.assertTrue (value);
    }
}
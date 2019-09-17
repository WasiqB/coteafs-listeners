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

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

/**
 * @author Wasiq Bhamla
 * @since 17-Sep-2019
 */
public class AnnotationTransformer implements IAnnotationTransformer {
    /*
     * (non-Javadoc)
     * @see @see org.testng.IAnnotationTransformer#transform(org.testng.annotations.
     * ITestAnnotation, java.lang.Class, java.lang.reflect.Constructor,
     * java.lang.reflect.Method)
     */
    @Override
    public void transform (final ITestAnnotation annotation, final Class testClass, final Constructor testConstructor,
        final Method testMethod) {
        annotation.setRetryAnalyzer (FailureRetry.class);
    }
}
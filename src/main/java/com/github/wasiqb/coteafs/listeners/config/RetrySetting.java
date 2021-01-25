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
package com.github.wasiqb.coteafs.listeners.config;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * @author Wasiq Bhamla
 * @since 17-Sep-2019
 */
@Data
public class RetrySetting {
    private boolean      enable;
    private boolean      logging;
    private int          maxRetry;
    private List<String> onExceptions;

    /**
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     */
    public RetrySetting () {
        this.enable = false;
        this.maxRetry = 2;
        this.logging = true;
        this.onExceptions = new ArrayList<> ();
    }
}
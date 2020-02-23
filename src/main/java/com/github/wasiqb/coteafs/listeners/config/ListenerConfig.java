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

import com.github.wasiqb.coteafs.config.util.BasePojo;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Wasiq Bhamla
 * @since 17-Sep-2019
 */
@Getter
@Setter
public class ListenerConfig extends BasePojo {
    private LogSetting   log;
    private RetrySetting recover;

    /**
     * @author Wasiq Bhamla
     * @since 17-Sep-2019
     */
    public ListenerConfig() {
        this.recover = new RetrySetting();
        this.log = new LogSetting();
    }
}
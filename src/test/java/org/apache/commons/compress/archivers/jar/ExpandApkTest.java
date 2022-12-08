/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.commons.compress.archivers.jar;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.examples.Expander;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.file.PathUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.lang3.stream.Streams;
import org.junit.jupiter.api.Test;

public class ExpandApkTest {

    @Test
    public void test() throws IOException {
        Streams
            .stream(
                PathUtils.walk(Paths.get("src/test/resources/android"), new SuffixFileFilter("." + ArchiveStreamFactory.APK, IOCase.INSENSITIVE), 100, false))
            .forEach(path -> new Expander().expand(ArchiveStreamFactory.APK, println(path), null));
    }

    private <T> T println(final T object) {
        // System.out.println(object);
        return object;
    }
}

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.text.matcher;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.text.StringSubstitutor;
import org.junit.jupiter.api.Test;

/**
 * Test class for {@link StringSubstitutor}.
 */
class StringSubstitutorGetSetTest {

    /**
     * Tests get set.
     */
    @Test
    void testGetSetPrefix() {
        final StringSubstitutor sub = new StringSubstitutor();
        assertTrue(sub.getVariablePrefixMatcher() instanceof AbstractStringMatcher.CharArrayMatcher);
        sub.setVariablePrefix('<');
        assertTrue(sub.getVariablePrefixMatcher() instanceof AbstractStringMatcher.CharMatcher);

        sub.setVariablePrefix("<<");
        assertTrue(sub.getVariablePrefixMatcher() instanceof AbstractStringMatcher.CharArrayMatcher);
        assertThrows(IllegalArgumentException.class, () -> sub.setVariablePrefix((String) null));
        assertTrue(sub.getVariablePrefixMatcher() instanceof AbstractStringMatcher.CharArrayMatcher);

        final StringMatcher matcher = StringMatcherFactory.INSTANCE.commaMatcher();
        sub.setVariablePrefixMatcher(matcher);
        assertSame(matcher, sub.getVariablePrefixMatcher());
        assertThrows(IllegalArgumentException.class, () -> sub.setVariablePrefixMatcher((StringMatcher) null));
        assertSame(matcher, sub.getVariablePrefixMatcher());
    }

    /**
     * Tests get set.
     */
    @Test
    void testGetSetSuffix() {
        final StringSubstitutor sub = new StringSubstitutor();
        assertTrue(sub.getVariableSuffixMatcher() instanceof AbstractStringMatcher.CharMatcher);
        sub.setVariableSuffix('<');
        assertTrue(sub.getVariableSuffixMatcher() instanceof AbstractStringMatcher.CharMatcher);

        sub.setVariableSuffix("<<");
        assertTrue(sub.getVariableSuffixMatcher() instanceof AbstractStringMatcher.CharArrayMatcher);
        assertThrows(IllegalArgumentException.class, () -> sub.setVariableSuffix((String) null));
        assertTrue(sub.getVariableSuffixMatcher() instanceof AbstractStringMatcher.CharArrayMatcher);

        final StringMatcher matcher = StringMatcherFactory.INSTANCE.commaMatcher();
        sub.setVariableSuffixMatcher(matcher);
        assertSame(matcher, sub.getVariableSuffixMatcher());
        assertThrows(IllegalArgumentException.class, () -> sub.setVariableSuffixMatcher((StringMatcher) null));
        assertSame(matcher, sub.getVariableSuffixMatcher());
    }

    /**
     * Tests get set.
     */
    @Test
    void testGetSetValueDelimiter() {
        final StringSubstitutor sub = new StringSubstitutor();
        assertTrue(sub.getValueDelimiterMatcher() instanceof AbstractStringMatcher.CharArrayMatcher);
        sub.setValueDelimiter(':');
        assertTrue(sub.getValueDelimiterMatcher() instanceof AbstractStringMatcher.CharMatcher);

        sub.setValueDelimiter("||");
        assertTrue(sub.getValueDelimiterMatcher() instanceof AbstractStringMatcher.CharArrayMatcher);
        sub.setValueDelimiter((String) null);
        assertNull(sub.getValueDelimiterMatcher());

        final StringMatcher matcher = StringMatcherFactory.INSTANCE.commaMatcher();
        sub.setValueDelimiterMatcher(matcher);
        assertSame(matcher, sub.getValueDelimiterMatcher());
        sub.setValueDelimiterMatcher((StringMatcher) null);
        assertNull(sub.getValueDelimiterMatcher());
    }

}

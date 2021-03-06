/*
 * Copyright (C) 2011 Sargis Harutyunyan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package info.sargis.eventbus.config;

import com.google.common.eventbus.EventBus;
import info.sargis.eventbus.config.handlers.regex.AnotherListener;
import info.sargis.eventbus.config.handlers.regex.SomeListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.InstanceOf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class EventBusRegexTest {

    @Autowired
    private EventBus eventBus;

    @Test
    public void testAnnotationExpression() throws Exception {
        verify(eventBus).register(argThat(new InstanceOf(SomeListener.class)));
        verify(eventBus).register(argThat(new InstanceOf(AnotherListener.class)));
    }

}

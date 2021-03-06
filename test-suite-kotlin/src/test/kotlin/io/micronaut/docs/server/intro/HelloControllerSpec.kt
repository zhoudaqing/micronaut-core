/*
 * Copyright 2017-2019 original authors
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
package io.micronaut.docs.server.intro

import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import junit.framework.TestCase

class HelloControllerSpec : TestCase() {

    fun testNullableFieldInjection() {
        var embeddedServer:EmbeddedServer= ApplicationContext.run(EmbeddedServer::class.java,
                mapOf("spec.name" to "HelloControllerSpec"),
                Environment.TEST)
        var client : HttpClient = HttpClient.create(embeddedServer.url)
        var rsp : String = client.toBlocking().retrieve("/hello")
        TestCase.assertEquals("Hello World", rsp)
        client.close()
        embeddedServer.close()
    }
}

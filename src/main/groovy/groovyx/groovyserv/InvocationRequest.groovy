/*
 * Copyright 2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package groovyx.groovyserv

import groovyx.groovyserv.exception.InvalidAuthTokenException
import groovyx.groovyserv.utils.LogUtils

/**
 * @author NAKANO Yasuharu
 */
class InvocationRequest {

    private long waitTime = 5000 // sec

    int port
    String cwd                 // optional
    String classpath           // optional
    List<String> args          // optional
    String clientAuthToken     // required
    AuthToken serverAuthToken  // required
    List<String> envVars       // optional
    String command             // optional

    /**
     * @throws InvalidAuthTokenException
     */
    void check() {
        if (!clientAuthToken || !serverAuthToken || !serverAuthToken.isValid(clientAuthToken)) {
            LogUtils.errorLog "Authentication failed. AuthToken is unmatched: ${clientAuthToken} <=> ******"
            Thread.sleep(waitTime) // to prevent from brute force attack
            throw new InvalidAuthTokenException("Authentication failed. AuthToken is unmatched: ${clientAuthToken} <=> ******")
        }
    }
}

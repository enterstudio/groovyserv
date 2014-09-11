/*
 * Copyright 2014 the original author or authors.
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

// The base title of page
title = "GroovyServ"

// The version of this documantation
version = "1.0-SNAPSHOT"

// The path of source files directory
sourceDirectoryPath = "source"

// Turn off numbering for topics
numbering = false

groovyVersion = "2.3.6"
javaVersion = "1.8.0_11"

// Filters
filters = {
    fontAwesome {
        before = { text ->
            text.replaceAll(/(?m)^( *[*-]) (.+) \{\.fa\.fa-([a-z-]+)\}$/, '$1 <i class="fa fa-$3"></i>$2')
        }
    }
    expandVersion {
        before = { text ->
            text.
                replaceAll(/(?m)<VERSION>/, version).
                replaceAll(/(?m)<GROOVY_VERSION>/, groovyVersion).
                replaceAll(/(?m)<JAVA_VERSION>/, javaVersion)
        }
    }
}

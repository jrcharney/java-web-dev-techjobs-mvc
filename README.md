# Java Web Dev Tech TechJobs MVC

## What wasn't in the instructions

If you start up the project you'll get this error:

```
Fixed "Could not initialize class org.codehaus.groovy.classgen.Verifier"
```

To fix this, we need to update the following things:

* Manditory: In `gradle/wrapper/gradle-wrapper.properties`, modify the first line to look more like this:
    > distributionUrl=https\://services.gradle.org/distributions/gradle-6.4.1-bin.zip
* Recommended: In `build.gradle`, the first eight lines should probably look more like this:
    > plugins {
    >  	id 'org.springframework.boot' version '2.2.8.RELEASE'
    >  	id 'io.spring.dependency-management' version '1.0.9.RELEASE'
    >  	id 'java'
    >  }
    >  
    >  group = 'org.launchcode'
    >  version = '0.0.1-SNAPSHOT'
    >  sourceCompatibility = '14'

This should fix a ton of problems from the start.

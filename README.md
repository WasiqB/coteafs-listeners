<p align="center">
  <a href="">
    <img src="assets/coteafs-listeners-logo.png" width=300 padding=10 />
  </a>
</p>

<h1 align="center">Runtime logging and recovery framework written in Java powered by TestNG.</h1>

<div align="center">

[![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)][home]
[![CircleCI](https://circleci.com/gh/WasiqB/coteafs-listeners.svg?style=svg)][circleci]
[![Test Coverage](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Alisteners&metric=coverage)][coverage]
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Alisteners&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.github.wasiqb.coteafs%3Alisteners)
[![Maintainability](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Alisteners&metric=sqale_rating)](https://sonarcloud.io/component_measures?id=com.github.wasiqb.coteafs%3Alisteners&metric=Maintainability)
[![Reliability](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Alisteners&metric=reliability_rating)](https://sonarcloud.io/component_measures?id=com.github.wasiqb.coteafs%3Alisteners&metric=Reliability)
[![Security](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Alisteners&metric=security_rating)](https://sonarcloud.io/component_measures?id=com.github.wasiqb.coteafs%3Alisteners&metric=Security)
[![Vulnerability](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Alisteners&metric=vulnerabilities)](https://sonarcloud.io/component_measures?id=com.github.wasiqb.coteafs%3Alisteners&metric=new_vulnerabilities)
[![Duplicate Code](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Alisteners&metric=duplicated_lines_density)](https://sonarcloud.io/component_measures?id=com.github.wasiqb.coteafs%3Alisteners&metric=Duplications)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.wasiqb.coteafs/listeners.svg)][maven]
[![Github Releases](https://img.shields.io/github/downloads/WasiqB/coteafs-listeners/total.svg)](https://github.com/WasiqB/coteafs-listeners/releases)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

</div>

## :boom: What's this all about?

coteafs-listeners was developed to add runtime logging capability to our test automation. It will report current test execution status as well as execution time. It is capable to retry failed tests as per configured criteria.

## :wrench: Sample Config file.

It expects a config file with name `listener-config.yml` at `src/test/resources` folder. You can change the file name or path by specifying the same in system property `coteafs.listener.config`.

```yaml
log:
   configurations: true
   data_provider: true
   execution: true
   suites: true
   tests: true
   suite_results: true
recover:
   enable: true
   logging: true
   max_retry: 1
   on_exceptions:
      - <Array list of fully qualified exception class name>
```

> It also supports config file with formats `json`, `xml` and `properties`.

## Usage

Add dependency to your POM file.

```xml
<dependency>
    <groupId>com.github.wasiqb.coteafs</groupId>
    <artifactId>listeners</artifactId>
    <version>2.4.0</version>
</dependency>
```

## Add to TestNG.xml file

Add listeners in `testng.xml` file in listener's block.

```xml
. . .
<listeners>
  <listener class-name="com.github.wasiqb.coteafs.listeners.ConfigListener" />
  <listener class-name="com.github.wasiqb.coteafs.listeners.SuiteListener" />
  <listener class-name="com.github.wasiqb.coteafs.listeners.TestListener" />
  <listener class-name="com.github.wasiqb.coteafs.listeners.ExecutionListener" />
  <listener class-name="com.github.wasiqb.coteafs.listeners.DataProviderListener" />
  <listener class-name="com.github.wasiqb.coteafs.listeners.AnnotationTransformer" />
  <listener class-name="com.github.wasiqb.coteafs.listeners.SuiteResultReporter" />
</listeners>
. . .
```

## Add to POM file

Add listeners in your `pom.xml` file.

```xml
. . .
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-surefire-plugin</artifactId>
	<version>2.20.1</version>
	. . .
	<configuration>
		<properties>
			<property>
				<name>listener</name>
				<value>
					com.github.wasiqb.coteafs.listeners.ConfigListener,com.github.wasiqb.coteafs.listeners.SuiteListener,com.github.wasiqb.coteafs.listeners.TestListener,com.github.wasiqb.coteafs.listeners.ExecutionListener,com.github.wasiqb.coteafs.listeners.DataProviderListener,com.github.wasiqb.coteafs.listeners.AnnotationTransformer,com.github.wasiqb.coteafs.listeners.SuiteResultReporter
				</value>
			</property>
		</properties>
		. . .
	</configuration>
</plugin>
. . .
```

### Sample output Runtime Logging

```bash
[15:22:28.266] [INFO ] - ================================================== (ExecutionListener:190) 
[15:22:28.268] [INFO ] - TestNG Execution started... (ExecutionListener:190) 
[15:22:28.268] [INFO ] - ================================================== (ExecutionListener:190) 
[15:22:28.441] [INFO ] - ================================================== (SuiteListener:190) 
[15:22:28.442] [INFO ] - Test Suite Execution started for Suite [Listener Suite]... (SuiteListener:190) 
[15:22:28.442] [INFO ] - ================================================== (SuiteListener:190) 
[15:22:28.445] [INFO ] - ================================================== (TestListener:190) 
[15:22:28.446] [INFO ] - Test Execution started for Test [Listener Test]... (TestListener:190) 
[15:22:28.446] [INFO ] - ================================================== (TestListener:190) 
[15:22:28.458] [INFO ] - ================================================== (ConfigListener:190) 
[15:22:28.458] [INFO ] - Configuration method [setupTest] is executing... (ConfigListener:190) 
[15:22:28.458] [INFO ] - ================================================== (ConfigListener:190) 
[15:22:28.469] [INFO ] - ================================================== (ConfigListener:190) 
[15:22:28.473] [INFO ] - [+] - Configuration method [setupTest] PASSED... (ConfigListener:190) 
[15:22:28.479] [INFO ] - Total Time taken: 0.008 secs (ConfigListener:190) 
[15:22:28.485] [INFO ] - ================================================== (ConfigListener:190) 
[15:22:28.519] [INFO ] - ================================================== (TestListener:190) 
[15:22:28.519] [INFO ] - Test Execution started for method [testRetry]... (TestListener:190) 
[15:22:28.520] [INFO ] - ================================================== (TestListener:190) 
[15:22:28.530] [INFO ] - ================================================== (FailureRetry:190) 
[15:22:28.532] [INFO ] - Started to retry the failed test [testRetry]... (FailureRetry:190) 
[15:22:28.533] [INFO ] - ================================================== (FailureRetry:190) 
[15:22:28.534] [INFO ] - ================================================== (TestListener:190) 
[15:22:28.534] [WARN ] - [*] - [testRetry] SKIPPED... (TestListener:265) 
[15:22:28.534] [WARN ] - null (TestListener:265) 
[15:22:28.534] [INFO ] - Total Time taken: 0.014 secs (TestListener:190) 
[15:22:28.534] [INFO ] - ================================================== (TestListener:190) 
[15:22:28.535] [INFO ] - ================================================== (TestListener:190) 
[15:22:28.535] [INFO ] - Test Execution started for method [testRetry]... (TestListener:190) 
[15:22:28.535] [INFO ] - ================================================== (TestListener:190) 
[15:22:28.539] [INFO ] - ================================================== (TestListener:190) 
[15:22:28.540] [INFO ] - [+] - [testRetry] PASSED... (TestListener:190) 
[15:22:28.540] [INFO ] - Total Time taken: 0.004 secs (TestListener:190) 
[15:22:28.541] [INFO ] - ================================================== (TestListener:190) 
[15:22:28.555] [INFO ] - ================================================== (DataProviderListener:190) 
[15:22:28.555] [INFO ] - Data provider [testSuccess] execution started... (DataProviderListener:190) 
[15:22:28.555] [INFO ] - ================================================== (DataProviderListener:190) 
[15:22:28.557] [INFO ] - ================================================== (DataProviderListener:190) 
[15:22:28.559] [INFO ] - Data provider [testSuccess] execution completed... (DataProviderListener:190) 
[15:22:28.560] [INFO ] - Total Time taken: 0.002 secs (DataProviderListener:190) 
[15:22:28.560] [INFO ] - ================================================== (DataProviderListener:190) 
[15:22:28.563] [INFO ] - ================================================== (TestListener:190) 
[15:22:28.564] [INFO ] - Test Execution started for method [testSuccess]... (TestListener:190) 
[15:22:28.564] [INFO ] - ================================================== (TestListener:190) 
[15:22:28.567] [INFO ] - ================================================== (TestListener:190) 
[15:22:28.567] [INFO ] - [+] - [testSuccess] PASSED... (TestListener:190) 
[15:22:28.568] [INFO ] - Total Time taken: 0.004 secs (TestListener:190) 
[15:22:28.570] [INFO ] - ================================================== (TestListener:190) 
[15:22:28.574] [INFO ] - ================================================== (ConfigListener:190) 
[15:22:28.580] [INFO ] - Configuration method [teardownTest] is executing... (ConfigListener:190) 
[15:22:28.581] [INFO ] - ================================================== (ConfigListener:190) 
[15:22:28.584] [INFO ] - ================================================== (ConfigListener:190) 
[15:22:28.585] [INFO ] - [+] - Configuration method [teardownTest] PASSED... (ConfigListener:190) 
[15:22:28.586] [INFO ] - Total Time taken: 0.011 secs (ConfigListener:190) 
[15:22:28.587] [INFO ] - ================================================== (ConfigListener:190) 
[15:22:28.587] [INFO ] - ================================================== (TestListener:190) 
[15:22:28.587] [INFO ] - Test Execution finished for Test [Listener Test]... (TestListener:190) 
[15:22:28.588] [INFO ] - Total Time taken: 0.024 secs (TestListener:190) 
[15:22:28.588] [INFO ] - ================================================== (TestListener:190) 
[15:22:28.592] [INFO ] - ================================================== (SuiteListener:190) 
[15:22:28.593] [INFO ] - Test Suite Execution finished for Suite [Listener Suite]... (SuiteListener:190) 
[15:22:28.593] [INFO ] - Total Time taken: 0.151 secs (SuiteListener:190) 
[15:22:28.594] [INFO ] - ================================================== (SuiteListener:190) 
[15:22:28.596] [INFO ] - ================================================== (SuiteResultReporter:190) 
[15:22:28.597] [INFO ] - Suite [Listener Suite]: Passed (SuiteResultReporter:190) 
[15:22:28.598] [INFO ] - -------------------------------------------------- (SuiteResultReporter:190) 
[15:22:28.598] [INFO ] - Total Tests: 2 (SuiteResultReporter:190) 
[15:22:28.598] [INFO ] - Passed Tests: 2 (SuiteResultReporter:190) 
[15:22:28.599] [INFO ] - Failed Tests: 0 (SuiteResultReporter:190) 
[15:22:28.599] [INFO ] - Skipped Tests: 1 (SuiteResultReporter:190) 
[15:22:28.600] [INFO ] - ================================================== (SuiteResultReporter:190) 
[15:22:28.600] [INFO ] - ================================================== (ExecutionListener:190) 
[15:22:28.601] [INFO ] - TestNG Execution finished... (ExecutionListener:190) 
[15:22:28.602] [INFO ] - Total Time taken: 0.337 secs (ExecutionListener:190) 
[15:22:28.602] [INFO ] - ================================================== (ExecutionListener:190)  
```

## :question: Need Assistance?

* Directly chat with me on my [site][] and I'll revert to you as soon as possible.
* Discuss your queries by writing to me @ wasbhamla2005@gmail.com
* If you find any issue which is bottleneck for you, [search the issue tracker][] to see if it is already raised.
* If not raised, then you can create a [new issue][] with required details as mentioned in the issue template.

## :star: What you do if you like the project?

* Spread the word with your network.
* **Star** the project to make the project popular.
* Stay updated with the project progress by **Watching** it.
* Contribute to fix open issues, documentations or add new features. To know more, see our [contributing][] page.
* I would be delighted if you can **Sponsor** this project and provide your support to open source development by clicking on the **Sponsor button** on the top of this repository.

## :heavy_check_mark: Contributors

<div>
  <ul>
    <li>
      <a href="https://github.com/WasiqB">
        <img alt="Wasiq Bhamla: Framework developer and maintainer." src="https://github.com/WasiqB.png" width=100 height=100 />
      </a>
    </li>
  </ul>
</div>

## :ticket: Versioning ideology

<p align="left">
  <a href="http://semver.org/">
    <img src="assets/semver.png" width=300 />
  </a>
</p>

## :copyright:Wasiq Bhamla

<p align="left">
  <a href="http://www.apache.org/licenses/LICENSE-2.0">
    <img src="http://www.apache.org/img/asf_logo.png" width=300 />
  </a>
</p>

[site]: https://wasiqb.github.io
[search the issue tracker]: https://github.com/WasiqB/coteafs-listeners/issues?q=something
[new issue]: https://github.com/WasiqB/coteafs-listeners/issues/new
[contributing]: .github/CONTRIBUTING.md
[home]: https://github.com/wasiqb/coteafs-listeners
[circleci]: https://circleci.com/gh/WasiqB/coteafs-listeners
[coverage]: https://sonarcloud.io/component_measures?id=com.github.wasiqb.coteafs%3Alistenerss&metric=Coverage
[maven]: https://maven-badges.herokuapp.com/maven-central/com.github.wasiqb.coteafs/listeners

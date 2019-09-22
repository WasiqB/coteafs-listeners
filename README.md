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
recover:
   enable: true
   logging: true
   max_retry: 1
   on_exceptions:
      - <Array list of fully qualified exception class name>
```

## Usage

Add dependency to your POM file.

```xml
<dependency>
    <groupId>com.github.wasiqb.coteafs</groupId>
    <artifactId>listeners</artifactId>
    <version>2.0.0</version>
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
					com.github.wasiqb.coteafs.listeners.ConfigListener,com.github.wasiqb.coteafs.listeners.SuiteListener,com.github.wasiqb.coteafs.listeners.TestListener,com.github.wasiqb.coteafs.listeners.ExecutionListener,com.github.wasiqb.coteafs.listeners.DataProviderListener,com.github.wasiqb.coteafs.listeners.AnnotationTransformer
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
[19:36:08.443] [INFO ] - ================================================== (ExecutionListener:65)
[19:36:08.445] [INFO ] - TestNG Execution started... (ExecutionListener:65)
[19:36:08.446] [INFO ] - ================================================== (ExecutionListener:65)
[19:36:08.540] [INFO ] - ================================================== (SuiteListener:65)
[19:36:08.540] [INFO ] - Test Suite Execution started for Suite [Suite]... (SuiteListener:65)
[19:36:08.541] [INFO ] - ================================================== (SuiteListener:65)
[19:36:08.543] [INFO ] - ================================================== (TestListener:65)
[19:36:08.543] [INFO ] - Test Execution started for Test [Test]... (TestListener:65)
[19:36:08.543] [INFO ] - ================================================== (TestListener:65)
[19:36:08.553] [INFO ] - ================================================== (ConfigListener:65)
[19:36:08.553] [INFO ] - Configuration method [setupTest] is executing... (ConfigListener:65)
[19:36:08.554] [INFO ] - ================================================== (ConfigListener:65)
[19:36:08.560] [INFO ] - ================================================== (ConfigListener:65)
[19:36:08.560] [INFO ] - [+] - Configuration method [setupTest] PASSED... (ConfigListener:65)
[19:36:08.562] [INFO ] - Total Time taken: 0.005 secs (ConfigListener:65)
[19:36:08.562] [INFO ] - ================================================== (ConfigListener:65)
[19:36:08.589] [INFO ] - ================================================== (TestListener:65)
[19:36:08.590] [INFO ] - Test Execution started for method [testRetry]... (TestListener:65)
[19:36:08.590] [INFO ] - ================================================== (TestListener:65)
[19:36:08.597] [INFO ] - ================================================== (FailureRetry:65)
[19:36:08.598] [INFO ] - Started to retry the failed test [testRetry]... (FailureRetry:65)
[19:36:08.598] [INFO ] - ================================================== (FailureRetry:65)
[19:36:08.599] [INFO ] - ================================================== (TestListener:65)
[19:36:08.599] [WARN ] - [*] - [testRetry] SKIPPED... (TestListener:85)
[19:36:08.600] [INFO ] - Total Time taken: 0.010 secs (TestListener:65)
[19:36:08.600] [INFO ] - ================================================== (TestListener:65)
[19:36:08.601] [INFO ] - ================================================== (TestListener:65)
[19:36:08.601] [INFO ] - Test Execution started for method [testRetry]... (TestListener:65)
[19:36:08.601] [INFO ] - ================================================== (TestListener:65)
[19:36:08.603] [INFO ] - ================================================== (TestListener:65)
[19:36:08.603] [INFO ] - [+] - [testRetry] PASSED... (TestListener:65)
[19:36:08.604] [INFO ] - Total Time taken: 0.002 secs (TestListener:65)
[19:36:08.604] [INFO ] - ================================================== (TestListener:65)
[19:36:08.608] [INFO ] - ================================================== (DataProviderListener:65)
[19:36:08.609] [INFO ] - Data provider [testSuccess] execution started... (DataProviderListener:65)
[19:36:08.609] [INFO ] - ================================================== (DataProviderListener:65)
[19:36:08.610] [INFO ] - ================================================== (DataProviderListener:65)
[19:36:08.610] [INFO ] - Data provider [testSuccess] execution completed... (DataProviderListener:65)
[19:36:08.611] [INFO ] - Total Time taken: 0.002 secs (DataProviderListener:65)
[19:36:08.611] [INFO ] - ================================================== (DataProviderListener:65)
[19:36:08.616] [INFO ] - ================================================== (TestListener:65)
[19:36:08.616] [INFO ] - Test Execution started for method [testSuccess]... (TestListener:65)
[19:36:08.617] [INFO ] - ================================================== (TestListener:65)
[19:36:08.619] [INFO ] - ================================================== (TestListener:65)
[19:36:08.620] [INFO ] - [+] - [testSuccess] PASSED... (TestListener:65)
[19:36:08.620] [INFO ] - Total Time taken: 0.003 secs (TestListener:65)
[19:36:08.620] [INFO ] - ================================================== (TestListener:65)
[19:36:08.622] [INFO ] - ================================================== (ConfigListener:65)
[19:36:08.623] [INFO ] - Configuration method [teardownTest] is executing... (ConfigListener:65)
[19:36:08.627] [INFO ] - ================================================== (ConfigListener:65)
[19:36:08.629] [INFO ] - ================================================== (ConfigListener:65)
[19:36:08.630] [INFO ] - [+] - Configuration method [teardownTest] PASSED... (ConfigListener:65)
[19:36:08.632] [INFO ] - Total Time taken: 0.007 secs (ConfigListener:65)
[19:36:08.632] [INFO ] - ================================================== (ConfigListener:65)
[19:36:08.633] [INFO ] - ================================================== (TestListener:65)
[19:36:08.633] [INFO ] - Test Execution finished for Test [Test]... (TestListener:65)
[19:36:08.634] [INFO ] - Total Time taken: 0.017 secs (TestListener:65)
[19:36:08.634] [INFO ] - ================================================== (TestListener:65)
[19:36:08.636] [INFO ] - ================================================== (SuiteListener:65)
[19:36:08.636] [INFO ] - Test Suite Execution finished for Suite [Suite]... (SuiteListener:65)
[19:36:08.636] [INFO ] - Total Time taken: 0.095 secs (SuiteListener:65)
[19:36:08.637] [INFO ] - ================================================== (SuiteListener:65)
[19:36:08.639] [INFO ] - ================================================== (ExecutionListener:65)
[19:36:08.640] [INFO ] - TestNG Execution finished... (ExecutionListener:65)
[19:36:08.641] [INFO ] - Total Time taken: 0.198 secs (ExecutionListener:65)
[19:36:08.641] [INFO ] - ================================================== (ExecutionListener:65) 
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

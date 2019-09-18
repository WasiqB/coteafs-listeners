<p align="center">
  <a href="">
    <img src="assets/coteafs-listeners-logo.png" width=300 padding=10 />
  </a>
</p>

<h1 align="center">Runtime logging and recovery framework written in Java powered by TestNG.</h1>

<div align="center">

[![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)][home]
[![CircleCI](https://circleci.com/gh/WasiqB/coteafs-logger.svg?style=svg)][circleci]
[![Test Coverage](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Alogger&metric=coverage)][coverage]
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Alogger&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.github.wasiqb.coteafs%3Alogger)
[![Maintainability](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Alogger&metric=sqale_rating)](https://sonarcloud.io/component_measures?id=com.github.wasiqb.coteafs%3Alogger&metric=Maintainability)
[![Reliability](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Alogger&metric=reliability_rating)](https://sonarcloud.io/component_measures?id=com.github.wasiqb.coteafs%3Alogger&metric=Reliability)
[![Security](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Alogger&metric=security_rating)](https://sonarcloud.io/component_measures?id=com.github.wasiqb.coteafs%3Alogger&metric=Security)
[![Vulnerability](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Alogger&metric=vulnerabilities)](https://sonarcloud.io/component_measures?id=com.github.wasiqb.coteafs%3Alogger&metric=new_vulnerabilities)
[![Duplicate Code](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Alogger&metric=duplicated_lines_density)](https://sonarcloud.io/component_measures?id=com.github.wasiqb.coteafs%3Alogger&metric=Duplications)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.wasiqb.coteafs/logger.svg)][maven]
[![Github Releases](https://img.shields.io/github/downloads/WasiqB/coteafs-logger/total.svg)](https://github.com/WasiqB/coteafs-logger/releases)
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

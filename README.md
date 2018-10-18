# coteafs-listeners

A ready to use TestNG listeners for run-time reporting of test execution. Just plug-n-play.

## Usage

Add dependency to your POM file.

```xml
<dependency>
    <groupId>com.github.wasiqb.coteafs</groupId>
    <artifactId>listeners</artifactId>
    <version>1.1.0</version>
</dependency>
```

### TestNG.xml file

Add listeners in `testng.xml` file in listener's block.

```xml
. . .
<listeners>
	<listener class-name="com.github.wasiqb.coteafs.listeners.ConfigListener" />
	<listener class-name="com.github.wasiqb.coteafs.listeners.SuiteListener" />
	<listener class-name="com.github.wasiqb.coteafs.listeners.TestListener" />
</listeners>
. . .
```

### POM file

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
					com.github.wasiqb.coteafs.listeners.ConfigListener,com.github.wasiqb.coteafs.listeners.SuiteListener,com.github.wasiqb.coteafs.listeners.TestListener
				</value>
			</property>
		</properties>
		. . .
	</configuration>
</plugin>
. . .
```

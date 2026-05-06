$repo = Join-Path $env:USERPROFILE ".m2\repository"

$dependencies = @(
    "org\springframework\boot\spring-boot\3.5.13\spring-boot-3.5.13.jar",
    "org\springframework\boot\spring-boot-autoconfigure\3.5.13\spring-boot-autoconfigure-3.5.13.jar",
    "org\springframework\spring-core\6.2.17\spring-core-6.2.17.jar",
    "org\springframework\spring-jcl\6.2.17\spring-jcl-6.2.17.jar",
    "org\springframework\spring-context\6.2.17\spring-context-6.2.17.jar",
    "org\springframework\spring-aop\6.2.17\spring-aop-6.2.17.jar",
    "org\springframework\spring-beans\6.2.17\spring-beans-6.2.17.jar",
    "org\springframework\spring-expression\6.2.17\spring-expression-6.2.17.jar",
    "org\springframework\spring-web\6.2.17\spring-web-6.2.17.jar",
    "org\springframework\spring-webmvc\6.2.17\spring-webmvc-6.2.17.jar",
    "org\apache\tomcat\embed\tomcat-embed-core\10.1.53\tomcat-embed-core-10.1.53.jar",
    "org\apache\tomcat\embed\tomcat-embed-el\10.1.53\tomcat-embed-el-10.1.53.jar",
    "org\apache\tomcat\embed\tomcat-embed-websocket\10.1.53\tomcat-embed-websocket-10.1.53.jar",
    "com\fasterxml\jackson\core\jackson-annotations\2.21\jackson-annotations-2.21.jar",
    "com\fasterxml\jackson\core\jackson-core\2.21.2\jackson-core-2.21.2.jar",
    "com\fasterxml\jackson\core\jackson-databind\2.21.2\jackson-databind-2.21.2.jar",
    "com\fasterxml\jackson\datatype\jackson-datatype-jdk8\2.21.2\jackson-datatype-jdk8-2.21.2.jar",
    "com\fasterxml\jackson\datatype\jackson-datatype-jsr310\2.21.2\jackson-datatype-jsr310-2.21.2.jar",
    "com\fasterxml\jackson\module\jackson-module-parameter-names\2.21.2\jackson-module-parameter-names-2.21.2.jar",
    "ch\qos\logback\logback-classic\1.5.32\logback-classic-1.5.32.jar",
    "ch\qos\logback\logback-core\1.5.32\logback-core-1.5.32.jar",
    "org\slf4j\slf4j-api\2.0.17\slf4j-api-2.0.17.jar",
    "org\slf4j\jul-to-slf4j\2.0.17\jul-to-slf4j-2.0.17.jar",
    "org\apache\logging\log4j\log4j-to-slf4j\2.24.3\log4j-to-slf4j-2.24.3.jar",
    "org\apache\logging\log4j\log4j-api\2.24.3\log4j-api-2.24.3.jar",
    "org\yaml\snakeyaml\2.4\snakeyaml-2.4.jar",
    "jakarta\annotation\jakarta.annotation-api\2.1.1\jakarta.annotation-api-2.1.1.jar",
    "io\micrometer\micrometer-observation\1.15.10\micrometer-observation-1.15.10.jar",
    "io\micrometer\micrometer-commons\1.15.10\micrometer-commons-1.15.10.jar"
)

$classpath = @("src\main\resources", "target\classes") + ($dependencies | ForEach-Object { Join-Path $repo $_ }) -join ";"
java -cp $classpath com.oopprac.contactmanager.ContactManagerApplication

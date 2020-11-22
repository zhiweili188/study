FROM java:8
MAINTAINER zhiweili188@126.com

RUN groupadd appuser
RUN useradd -g appuser apprun

ADD example.spring.docker*.jar /opt/app.jar
ADD entrypoint.sh  /opt/entrypoint.sh

RUN chown -R apprun:appuser /opt 
RUN chmod a+x /opt/entrypoint.sh

USER apprun
WORKDIR /opt/
RUN mkdir /opt/applog

VOLUME /tmp

ENV JAVA_OPTS=""
ENTRYPOINT [ "/bin/sh", "/opt/entrypoint.sh" ]
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/app.jar"]
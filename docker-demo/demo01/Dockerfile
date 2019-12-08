FROM java:8u111-jre-alpine

WORKDIR /home/apps/
ADD demo01-0.0.1-SNAPSHOT.jar .

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone

ENTRYPOINT ["java","-jar","demo01-0.0.1-SNAPSHOT.jar"]
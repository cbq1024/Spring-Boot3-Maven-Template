FROM bellsoft/liberica-openjdk-alpine:17 AS runner

ENV GRADLE_USER_HOME=/cache
ENV WORKDIR=/usr/src/app
WORKDIR $WORKDIR

RUN mkdir -p /var/log

COPY . .

RUN chmod a+x ./mvnw
RUN --mount=type=bind,target=.,rw \
    --mount=type=cache,target=$GRADLE_USER_HOME \
    ./mvnw -B clean compile &&  \
    ./mvnw -B package -DskipTests && \
    mv $WORKDIR/target/app.jar /app.jar

EXPOSE 8080

CMD java --add-opens java.base/java.lang=ALL-UNNAMED -jar /app.jar

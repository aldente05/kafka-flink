###
# vert.x docker example using a Java verticle
# To build:
#  docker build -t sample/vertx-java .
# To run:
#   docker run -t -i -p 8080:8080 sample/vertx-java
###

# Extend vert.x image
FROM vertx/vertx3

ENV VERTICLE_NAME omipos.MainVerticle
ENV VERTICLE_FILE target/kafka-flink-1.0.0-SNAPSHOT-fat.jar

# Set the location of the verticles
ENV VERTICLE_HOME /usr/verticles

EXPOSE 8080

# Copy your verticle to the container
COPY $VERTICLE_FILE $VERTICLE_HOME/

# Launch the verticle
WORKDIR $VERTICLE_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec vertx run $VERTICLE_NAME -cp $VERTICLE_HOME/*"]

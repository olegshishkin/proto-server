package com.olegshishkin.grpc;

import com.olegshishkin.grpc.proto.type.SimpleRq;
import com.olegshishkin.grpc.proto.type.SimpleRs;
import com.olegshishkin.grpc.proto.type.SimpleServiceGrpc.SimpleServiceImplBase;
import io.grpc.stub.StreamObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleServiceImpl extends SimpleServiceImplBase {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void call(SimpleRq request, StreamObserver<SimpleRs> responseObserver) {
        LOGGER.info("Rq: [name: {}, age: {}]", request.getName(), request.getAge());
        SimpleRs rs = SimpleRs.newBuilder()
                .setMsg("rq " + request.getName() + " received")
                .build();
        responseObserver.onNext(rs);
        responseObserver.onCompleted();
    }
}

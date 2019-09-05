// GENERATED CODE -- DO NOT EDIT!

'use strict';
var grpc = require('grpc');
var proto_Student_pb = require('../proto/Student_pb.js');

function serialize_hhz_demo10_proto_MyRequest(arg) {
  if (!(arg instanceof proto_Student_pb.MyRequest)) {
    throw new Error('Expected argument of type hhz.demo10.proto.MyRequest');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_hhz_demo10_proto_MyRequest(buffer_arg) {
  return proto_Student_pb.MyRequest.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_hhz_demo10_proto_MyResponse(arg) {
  if (!(arg instanceof proto_Student_pb.MyResponse)) {
    throw new Error('Expected argument of type hhz.demo10.proto.MyResponse');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_hhz_demo10_proto_MyResponse(buffer_arg) {
  return proto_Student_pb.MyResponse.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_hhz_demo10_proto_StreamRequest(arg) {
  if (!(arg instanceof proto_Student_pb.StreamRequest)) {
    throw new Error('Expected argument of type hhz.demo10.proto.StreamRequest');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_hhz_demo10_proto_StreamRequest(buffer_arg) {
  return proto_Student_pb.StreamRequest.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_hhz_demo10_proto_StreamResponse(arg) {
  if (!(arg instanceof proto_Student_pb.StreamResponse)) {
    throw new Error('Expected argument of type hhz.demo10.proto.StreamResponse');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_hhz_demo10_proto_StreamResponse(buffer_arg) {
  return proto_Student_pb.StreamResponse.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_hhz_demo10_proto_StudentRequest(arg) {
  if (!(arg instanceof proto_Student_pb.StudentRequest)) {
    throw new Error('Expected argument of type hhz.demo10.proto.StudentRequest');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_hhz_demo10_proto_StudentRequest(buffer_arg) {
  return proto_Student_pb.StudentRequest.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_hhz_demo10_proto_StudentResponse(arg) {
  if (!(arg instanceof proto_Student_pb.StudentResponse)) {
    throw new Error('Expected argument of type hhz.demo10.proto.StudentResponse');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_hhz_demo10_proto_StudentResponse(buffer_arg) {
  return proto_Student_pb.StudentResponse.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_hhz_demo10_proto_StudentResponseList(arg) {
  if (!(arg instanceof proto_Student_pb.StudentResponseList)) {
    throw new Error('Expected argument of type hhz.demo10.proto.StudentResponseList');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_hhz_demo10_proto_StudentResponseList(buffer_arg) {
  return proto_Student_pb.StudentResponseList.deserializeBinary(new Uint8Array(buffer_arg));
}


var StudentServiceService = exports.StudentServiceService = {
  getRealNameByUsername: {
    path: '/hhz.demo10.proto.StudentService/GetRealNameByUsername',
    requestStream: false,
    responseStream: false,
    requestType: proto_Student_pb.MyRequest,
    responseType: proto_Student_pb.MyResponse,
    requestSerialize: serialize_hhz_demo10_proto_MyRequest,
    requestDeserialize: deserialize_hhz_demo10_proto_MyRequest,
    responseSerialize: serialize_hhz_demo10_proto_MyResponse,
    responseDeserialize: deserialize_hhz_demo10_proto_MyResponse,
  },
  getStudentsByAge: {
    path: '/hhz.demo10.proto.StudentService/GetStudentsByAge',
    requestStream: false,
    responseStream: true,
    requestType: proto_Student_pb.StudentRequest,
    responseType: proto_Student_pb.StudentResponse,
    requestSerialize: serialize_hhz_demo10_proto_StudentRequest,
    requestDeserialize: deserialize_hhz_demo10_proto_StudentRequest,
    responseSerialize: serialize_hhz_demo10_proto_StudentResponse,
    responseDeserialize: deserialize_hhz_demo10_proto_StudentResponse,
  },
  getStudentsWrapperByAges: {
    path: '/hhz.demo10.proto.StudentService/GetStudentsWrapperByAges',
    requestStream: true,
    responseStream: false,
    requestType: proto_Student_pb.StudentRequest,
    responseType: proto_Student_pb.StudentResponseList,
    requestSerialize: serialize_hhz_demo10_proto_StudentRequest,
    requestDeserialize: deserialize_hhz_demo10_proto_StudentRequest,
    responseSerialize: serialize_hhz_demo10_proto_StudentResponseList,
    responseDeserialize: deserialize_hhz_demo10_proto_StudentResponseList,
  },
  biTalk: {
    path: '/hhz.demo10.proto.StudentService/BiTalk',
    requestStream: true,
    responseStream: true,
    requestType: proto_Student_pb.StreamRequest,
    responseType: proto_Student_pb.StreamResponse,
    requestSerialize: serialize_hhz_demo10_proto_StreamRequest,
    requestDeserialize: deserialize_hhz_demo10_proto_StreamRequest,
    responseSerialize: serialize_hhz_demo10_proto_StreamResponse,
    responseDeserialize: deserialize_hhz_demo10_proto_StreamResponse,
  },
};

exports.StudentServiceClient = grpc.makeGenericClientConstructor(StudentServiceService);

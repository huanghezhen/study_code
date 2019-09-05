var PROTO_FILE_PATH = 'C:\\Users\\hat\\ideaws\\gradlews\\grpc_demo\\proto\\Student.proto';
var grpc = require('grpc');
var grpcService = grpc.load(PROTO_FILE_PATH).hhz.demo10.proto;

var client = new grpcService.StudentService('localhost:8899', grpc.credentials.createInsecure());

client.getRealNameByUsername({username: 'lisi'}, function (error, respData) {
    console.log(respData);
});
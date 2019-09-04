# -*- coding:utf-8 -*-
from thrift.server import TServer

from PersonServiceImpl import PersonServiceImpl
from py.thrift.generated import PersonService

from thrift import Thrift
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TCompactProtocol

__author__ = '作者'


try:
    personServiceHandler = PersonServiceImpl()
    processor = PersonService.Processor(personServiceHandler)

    serverSocket = TSocket.TServerSocket(host='127.0.0.1',port=8899)
    transportFactory = TTransport.TFramedTransportFactory()
    protocolFactory = TCompactProtocol.TCompactProtocolFactory()

    server = TServer.TSimpleServer(processor,serverSocket,transportFactory,protocolFactory)
    server.serve()

except Thrift.TException as tx:
    print(tx)



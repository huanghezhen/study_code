# -*- coding:utf-8 -*-
__author__ = '作者'
from py.thrift.generated import PersonService
from py.thrift.generated import ttypes
from thrift import Thrift
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TCompactProtocol

class PersonServiceImpl:
    def getPersonByUsername(self,username):
        print("got client parma: " + username)

        person = ttypes.Person()
        person.username = username
        person.age = 18
        person.married = False
        return person
    def savePerson(self,person):
        print("got client parma: ")
        print(person.username)
        print(person.age)
        print(person.married)








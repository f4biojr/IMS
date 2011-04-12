#!/usr/bin/python

import MySQLdb
from xml.dom import minidom as dom


def criaArquivo( sServidor ):
    sArquivo = dom.Document()
    
    servidor = sArquivo.createElement( sServidor )
    dados = sArquivo.createElement( "dados" )
    ip = sArquivo.createElement("IP")
    hostname = sArquivo.createElement("hostname")
    ip = sArquivo.createElement("IP")
    ip = sArquivo.createElement("IP")
    ip = sArquivo.createElement("IP")
    
    sArquivo.appendChild(servidor)
    
    

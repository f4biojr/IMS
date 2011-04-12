
# To change this template, choose Tools | Templates
# and open the template in the editor.
import commands


__author__="fabio"
__date__ ="$29/06/2009 15:21:14$"

class Servidor:
    id = None
    ip = None
    community = None
    servicos = list()
    
    def __init__(self, id, ip, community):
        self.id         = id
        self.ip         = ip
        self.community  = community
        
    def getIp(self):
        return self.ip

    def setIp(self, ip):
        self.ip = ip

    def getId(self):
        return self.id

    def setId(self, id):
        self.id = id

    def getCommunity(self):
        return self.community

    def setCommunity(self, community):
        self.community = community


    def getConsulta(self, mib):
        resultado = commands.getoutput("snmpget -v1 -c " + self.community + " " + self.ip + " " + mib + "|awk {'print $4'}")
        try:
        	resultado = resultado.split('"')[1]
        	return resultado
        except:
        	return resultado

    def getStatus(self):
        print commands.getoutput("snmpstatus -v1 -c " + self.community + " " + self.getIp())
         
    def getServicos(self):
        return self.servicos
    
    def setServicos(self, servicos):
        self.servicos.append(servicos)

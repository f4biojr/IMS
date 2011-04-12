# -*- coding: UTF-8 -*-

from config import Config 
from banco import Banco
from servidor import Servidor


class IMS:
    
    STATUS      =   None
    CONFIGFILE  =   None
    CONFIG      =   None
    BANCO       =   None
    
    def __init__(self, comando, configfile):
        if ( comando == "start"):
            self.CONFIGFILE = configfile
            self.start()
        else:
            self.erro("comando")
           
    def start(self):
        self.CONFIG = Config(self.CONFIGFILE)
        self.BANCO = Banco(self.CONFIG)
        self.main()
    
    def reload(self):
        self.CONFIG = Config(self.CONFIGFILE)
        self.BANCO  = Banco(self.CONFIG.getDatabase(), self.CONFIG.getUsuario(), self.CONFIG.getHostname(), self.CONFIG.getPassword())
        self.main()

    
    def main(self):
    
        Servidores = list()
        for dadosServidor in self.BANCO.getServidores():
            servidor = Servidor(dadosServidor[0],dadosServidor[1],dadosServidor[2])
            Servidores.append(servidor)
        
        
        cont = 0
        #print len(Servidores)
        while cont < len(Servidores):
            servId = Servidores[cont].getId()
            servicos = self.BANCO.getServicos(servId)
            #print "quantidade de servicos " + len(servicos).__str__()
            #print servId
            for servico in servicos:
                Servidores[cont].setServicos(self.BANCO.getMib(servico))
            cont = cont + 1
            
        for servidor in Servidores:
            #print servidor.getServicos()
            for servico in servidor.getServicos():
                self.BANCO.salvaDados(self.BANCO.getIdMib(servico), servidor.getId(), servidor.getConsulta(servico))
                #print servidor.getIp()
                #print servidor.getConsulta(servico)

        
            
    def erro(self, causa):            
        if (causa == "comando"):
            print "Parâmetro inválido."
            print "Usage: start|stop|restart|status"
       
        
    #def stop(self):
        
    #def reload(self):
        
    #def status(self):


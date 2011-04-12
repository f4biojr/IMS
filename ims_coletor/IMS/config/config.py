# -*- coding: UTF-8 -*-

import ConfigParser

class Config:
    
    config      =   ConfigParser.ConfigParser()
    database    =   None
    hostname    =   None
    usuario     =   None
    password    =   None
    intervalo   =   None    
    
    
    def __init__(self, configFile):
        self.config.read(configFile)
        self.setDatabase()
        self.setHostname()
        #self.setIntervalo()
        self.setPassword()
        self.setUsuario()
    
    def setDatabase(self):
        self.database = self.config.get('DB','database')
        
    def getDatabase(self):
        return self.database
        
    
    def setHostname(self):
        self.hostname = self.config.get('DB','hostname')
    
    def getHostname(self):
        return self.hostname
        
        
    def setUsuario(self):
        self.usuario = self.config.get('DB','usuario')
    
    def getUsuario(self):
        return self.usuario
        
    
    def setPassword(self):
        self.password = self.config.get('DB','password')    
    
    def getPassword(self):
        return self.password
        
    
    def setIntervalo(self):
        self.intervalo = self.config.get('Geral','intervalo')
    
    def getIntervalo(self):
        return self.intervalo
    
    def getAll(self):
        return self.database, self.usuario, self.hostname, self.password
    
        
        
    
    
    
    
    
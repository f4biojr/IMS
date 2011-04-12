# -*- coding: UTF-8 -*-

#Classe de banco

#Importa a biblioteca de conexão com o banco
#import PgSQL
import MySQLdb
import sys

#Classe banco
class Banco:
    
    dbName      =   None #nome do banco
    dbHost      =   None #hostname onde o banco se encontra
    dbUser      =   None #usuario do banco
    dbPassword  =   None #password do usuario
    conexao     =   None #conexao com o banco
    
    def __init__(self, dbConf):
        self.dbName = dbConf.getDatabase()
        self.dbUser = dbConf.getUsuario()
        self.dbHost = dbConf.getHostname()
        self.dbPassword = dbConf.getPassword()
        self.conexao = self.getConection()
        

    def getDbName(self):
        return self.dbName


    def getDbHost(self):
        return self.dbHost


    def getDbUser(self):
        return self.dbUser


    def getDbPassword(self):
        return self.dbPassword


    def setDbName(self, value):
        self.dbName = value


    def setDbHost(self, value):
        self.dbHost = value


    def setDbUser(self, value):
        self.dbUser = value


    def setDbPassword(self, value):
        self.dbPassword = value

    def getConexao(self):
        return self.conexao
    
    def getConection(self):
        try:
#           token = PgSQL.connect(user=self.getDbUser(),password=self.getDbPassword(),database=self.getDbName(),host=self.getDbHost())
            token = MySQLdb.connect(user=self.getDbUser(),passwd=self.getDbPassword(),db=self.getDbName(),host=self.getDbHost())
            return token
        except:
            #print 'Erro ao conectar ao banco'
            sys.exit('Erro ao conectar ao banco')

    def getIdServidor(self):
        query = "SELECT srv_id FROM servidores;"
        token = self.getConection()
        ponteiro = token.cursor()
        ponteiro.execute(query)
        linhas = ponteiro.fetchall()
        linhas = linhas.__str__()
        linhas = linhas.replace('(','').replace(')','').replace('\'','').replace(',','').replace(']','').replace('[','')
        return linhas
    
    def getServidores(self):
        query = "SELECT * FROM servidores;"
        ponteiro = self.conexao.cursor()
        ponteiro.execute(query)
        linhas = ponteiro.fetchall()
        #linhas = linhas.__str__()
        #linhas = linhas.replace('(','').replace(')','').replace('\'','').replace(',','').replace(']','').replace('[','')
        return linhas

    def getIpServidor(self):
        query = "SELECT srv_ip FROM servidores;"
        ponteiro = self.getConection().cursor()
        ponteiro.execute(query)
        linhas = ponteiro.fetchall()
        a = list()
        for i in linhas:
            a.append(i.__str__().replace('(','').replace(')','').replace('\'','').replace(',','').replace(']','').replace('[',''))
        return a

    def getIdMib(self, mib):
        query = "SELECT src_id FROM servicos WHERE src_mib='" + mib + "';"
        ponteiro = self.getConection().cursor()
        ponteiro.execute(query)
        linhas = ponteiro.fetchall()
        #ids = list()
        #for id in linhas:
            #ids.append(id.__str__().replace('(','').replace(')','').replace(',',''))
        return linhas.__str__().replace('(','').replace(')','').replace(',','').replace('L','')
        

    def getMib(self, idMib):
        query = "SELECT src_mib FROM servicos WHERE src_id=" + idMib + ";"
        ponteiro = self.getConection().cursor()
        ponteiro.execute(query)
        linha = ponteiro.fetchall()
        #print linha
        #mibs = list()
        #for mib in linhas:
            #mibs.append(mib.__str__().replace('(','').replace(')','').replace('\'','').replace(',',''))
        mib = linha.__str__().replace('(','').replace(')','').replace('\'','').replace(',','').replace(']','').replace('[','')
        return mib
    
    def getServicos(self,id):
        query = "SELECT shs_id_servico FROM servidor_has_servicos WHERE shs_id_servidor=" + id.__str__() + ";"
        ponteiro = self.getConection().cursor()
        ponteiro.execute(query)
        linhas = ponteiro.fetchall()
        servicos = list()
        for mib in linhas:
            servicos.append(mib.__str__().replace('(','').replace(')','').replace('\'','').replace(',','').replace(']','').replace('[','').replace('L',''))
        return servicos
        

    def salvaDados(self,idMib,idServidor,resultado):
        #print idMib, idServidor, resultado
        query = "INSERT INTO estado(est_id_servidor,est_id_servico,est_estado,est_horario) VALUES(" + idServidor.__str__() + "," + idMib.__str__() + ",'" + resultado.__str__() +"',DATE_FORMAT(now(), '%Y-%m-%d %H:%i'));"
        ponteiro = self.getConexao().cursor()
        ponteiro.execute(query)
        self.getConexao().commit()
        

        

        
        
    
    
        

#!/bin/bash

# Script de instalação do daemon de obtenção de dados do sistema IMS


# Verificando se o Python esta instalado
echo -e 'Verficando se o Python está instalado...'
which python > /dev/null
if  [ $? = 0 ]
then
	echo -e 'Python \t\t\t[ \033[032;1mOK\033[0m ]\n'
else
	echo -e "Python \t\t\t[ \033[031;1mFalhou\033[0m ]"
	echo -e "\tVerifique a versão do python instalada e tente novamente."
	echo -e "\tInformações sobre pré-requisitos podem ser encontradas no arquivo INSTALL."
fi

# Copiando as bibliotecas do daemon
echo -e 'Copiando bibliotecas necessárias para execução do ims_daemon...\n'
sleep 1

#lib IMS
sudo ln -s /home/fabio/Univali/Projeto_Integrador_5/IMS/ims_coletor/IMS/ims.py /usr/lib/python2.6/.
if  [ $? = 0 ]
then
	echo -e 'lib IMS \t\t\t[ \033[032;1mOK\033[0m ]'
	sleep 1
fi

#lib Config
sudo ln -s /home/fabio/Univali/Projeto_Integrador_5/IMS/ims_coletor/IMS/config/config.py /usr/lib/python2.6/.
if  [ $? = 0 ]
then
	echo -e 'lib config \t\t\t[ \033[032;1mOK\033[0m ]'
	sleep 1
fi

#lib Banco
sudo ln -s /home/fabio/Univali/Projeto_Integrador_5/IMS/ims_coletor/IMS/banco/banco.py /usr/lib/python2.6/.
if  [ $? = 0 ]
then
	echo -e 'lib banco \t\t\t[ \033[032;1mOK\033[0m ]'
	sleep 1
fi

#lib Servidor
sudo ln -s /home/fabio/Univali/Projeto_Integrador_5/IMS/ims_coletor/IMS/servidor/servidor.py /usr/lib/python2.6/.
if  [ $? = 0 ]
then
	echo -e 'lib servidor \t\t\t[ \033[032;1mOK\033[0m ]\n'
	sleep 1
fi

echo -e 'Adicionando script ao crontab...\n'
sudo echo '/5 * * * * root python /home/fabio/Univali/Projeto_Integrador_5/IMS/ims_coletor/bin/ims_daemon.py'
if  [ $? = 0 ]
then
	echo -e 'Crontab \t\t\t[ \033[032;1mOK\033[0m ]\n'
	sleep 1
fi

echo -e 'Instalação concluída com sucesso!'


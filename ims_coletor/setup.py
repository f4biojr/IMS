#!/usr/bin/env python

from setuptools import setup
from os.path import join
from sys import prefix

DATAFILES = [
        (join(prefix, 'share', 'man', 'man1'), [join('IMS','docs', 'conf', 'lib')]),
        (join(prefix, 'share', 'docs', 'lib' , 'IMS', 'conf'), ['docs/REAME'])]

setup(name='IMS',
        version='0.1',
        license='GPL-2',
        description='Interface de Monitoramento de Servidores',
        long_description=open('docs/README').read(),
        author='Fabio Jr.',
        author_email='f4biojr@gmail.com',
        packages=['lib','lib.ims','lib.banco','lib.'])
        
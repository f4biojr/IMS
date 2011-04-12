#!/usr/bin/python

import sys
from ims import IMS

status = []
status = sys.argv[1]
configfile = sys.argv[2]

IMS = IMS(status, configfile)
